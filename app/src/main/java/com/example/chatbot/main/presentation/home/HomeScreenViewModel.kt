package com.example.chatbot.main.presentation.home

import RecommendationMatrix
import RecommendationMatrixImpl
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot.main.data.database_messages.model.Instruction
import com.example.chatbot.main.data.database_messages.model.SessionMetadata
import com.example.chatbot.main.data.database_messages.model.ThreadMetadata
import com.example.chatbot.main.data.module.MainModule
import com.example.chatbot.main.data.database_questions.entity.TopicMetadata
import com.example.chatbot.main.domain.instruction_factory.GPTResponseFormat
import com.example.chatbot.main.domain.pre_defined_questions.predefinedTopics
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.util.Date
import java.util.Random
import kotlin.math.absoluteValue


class HomeScreenViewModel:ViewModel() {

    // Late-initialized property to hold the MainModule instance.
    private lateinit var module: MainModule

    // MutableStateFlow to represent the list of topics.
    private val _topics = MutableStateFlow<List<TopicMetadata>>(emptyList())
    val topics = _topics.asStateFlow()

    // MutableStateFlow to represent the list of recent sessions.
    private val _recentSessions = MutableStateFlow<List<SessionMetadata>>(emptyList())
    val recentSessions = _recentSessions.asStateFlow()

    private val _selectedTopics = MutableStateFlow<List<TopicMetadata>>(emptyList())
    val selectedTopics = _selectedTopics.asStateFlow()

    private val _questionCount = MutableStateFlow<Int>(10)
    val questionCount = _questionCount.asStateFlow()

    // Function to set the MainModule instance.
    fun setModule(newModule: MainModule) {
        // Assign the new MainModule instance to the class property.
        this.module = newModule

        // Launch a coroutine in the IO dispatcher to fetch topics asynchronously.
        viewModelScope.launch(Dispatchers.IO) {
            // Update the topics StateFlow with the result of getAllTopics() from the questionRepository.
            _topics.update {
                module.questionRepository.getAllTopics()
            }
            _recentSessions.update {
                module.conversationRepository.retrieveSessionsByUserUid(module.currentUser.uid)
            }
        }
    }



    // Function to retrieve the current user from the MainModule.
    fun getCurrentUser() = module.currentUser

    // Function to get questions metadata for a specific topic.
    // Returns a Flow emitting a list of integers representing question statuses.
    fun getQuestionsMetadataForTopic(topicUid: Int): Flow<List<Int>> = flow {
        // Emit the list of question statuses for the specified topic and current user.
        emit(
            module.questionRepository.getAllMetadataForTopic(topicUid, module.currentUser.uid)
                .map { it.status }
        )
    }

    fun onTopicSelected(topicMetadata: TopicMetadata) {
        _selectedTopics.update { current ->
            if (topicMetadata !in current) {
                if (current.size < 5) current + topicMetadata
                else current
            } else current - topicMetadata
        }
        Log.d(
            "Test",
            "Selected topics = ${_selectedTopics.value.map { it.label.split(" ").first() }}"
        )
    }

    fun onQuestionCountChanged(newCount: Int) {
        _questionCount.update { newCount }
    }

    // Function to get topic labels based on a string containing topic UIDs.
    fun getTopicsLabel(s: String): List<String> {
        // Split the input string into a list of topic UIDs and filter out blank entries.
        val ids = s.split('/').filter { it.isNotBlank() }.map { it.toInt() }

        // Return the labels of predefined topics whose UIDs match the extracted IDs.
        return predefinedTopics.filter { it.uid in ids }.map { it.label }
    }

    fun createNewSession(onNewSessionCreated: (Long) -> Unit) {
        try{
            viewModelScope.launch(Dispatchers.IO) {

                // Build the coefficient matrix
                val recommendationMatrix = RecommendationMatrixImpl(
                    module.questionRepository.buildWeightMatrix(
                        _selectedTopics.value.map { it.uid },
                        module.currentUser.uid
                    )
                )

                // Temp value to store the question UIDs
                val pickedQuestion = mutableListOf<Int>()

                // Determine the amount of questions per topic
                val questionAmountPerTopic = if (_selectedTopics.value.isNotEmpty())
                    _questionCount.value / _selectedTopics.value.size else _questionCount.value

                // Append all the questions
                _selectedTopics.value.onEach {
                    pickedQuestion += recommendationMatrix.getRecommendedQuestions(
                        it.uid,
                        questionAmountPerTopic
                    )
                }

                // Generate a new session UID
                val sessionUid = module.uidGenerator.generateLong()

                // Build topicsSelectedField as a string representation of selected topics' UIDs
                val topicsSelectedField = buildString {
                    _selectedTopics.value.map { it.uid }.onEach {
                        append(it)
                        append("/")
                    }
                }

                // Build questionUidsString as a string representation of picked question UIDs
                //TODO must rework to fix beacuse it returns the indices relative to the row now the question Uid itself
                val questionUidsString = buildString {
                    pickedQuestion.onEach {
                        append(it)
                        append("/")
                    }
                }

                // Create a new session metadata
                val session = SessionMetadata(
                    uid = sessionUid,
                    userUid = module.currentUser.uid,
                    status = SessionMetadata.STARTED,
                    timestamp = System.currentTimeMillis(),
                    topicsUids = topicsSelectedField,
                    questionUids = questionUidsString
                )

                // Create new set of threads for each picked question
                pickedQuestion.onEach {
                    val threadUID = module.uidGenerator.generateLong()
                    val instructionUID = module.uidGenerator.generateLong()
                    val questionRow = module.questionRepository.getQuestionByUid(it)
                        ?: throw NullPointerException("Question with uid = $it was not found")
                    // Build instruction using GPTResponseFormat.DefaultFormat
                    val instruction = module.questionRepository.getInstructionFactory()
                        .buildInstruction(
                            GPTResponseFormat.DefaultFormat,
                            questionRow,
                            instructionUID,
                            threadUID
                        )

                    // Create thread metadata
                    val thread = ThreadMetadata(
                        uid = threadUID,
                        sessionUid = sessionUid,
                        questionUid = it,
                        instructionUid = instructionUID
                    )

                    // Add instruction and thread metadata to the conversation repository
                    module.conversationRepository.addInstruction(instruction).onFailure {
                        it.printStackTrace()
                    }

                    module.conversationRepository.addThreadMetadata(thread).onFailure {
                        it.printStackTrace()
                    }
                }

                // Add the session to the database
                module.conversationRepository.addSessionsMetadata(sessionMetadata = session)
                    .onFailure {
                        it.printStackTrace()
                    }.onSuccess {
                        Log.d("Test" , "Session Created Successfully")
                    withContext(Dispatchers.Main) {
                        onNewSessionCreated(sessionUid)
                    }
                }
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

}