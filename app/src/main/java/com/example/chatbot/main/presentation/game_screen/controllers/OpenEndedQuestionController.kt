package com.example.chatbot.main.presentation.game_screen.controllers

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.aallam.openai.api.BetaOpenAI
import com.example.chatbot.main.data.database_messages.model.Instruction
import com.example.chatbot.main.data.database_messages.model.Message
import com.example.chatbot.main.data.database_questions.entity.Question
import com.example.chatbot.main.data.database_questions.entity.QuestionMetadata
import com.example.chatbot.main.data.openai.ChatCompletionRequestBuilder
import com.example.chatbot.main.data.openai.OpenAIClient
import com.example.chatbot.main.data.openai.OpenAIClientImpl
import com.example.chatbot.main.domain.instruction_factory.GPTResponse
import com.example.chatbot.main.domain.instruction_factory.GPTResponseFormat
import com.example.chatbot.main.presentation.game_screen.model.QuizEvent
import com.example.chatbot.main.presentation.game_screen.model.QuizState
import com.example.chatbot.main.presentation.game_screen.layouts.OpenEndedQuizLayout
import com.example.chatbot.main.presentation.game_screen.layouts.QuizLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

/**
 * Concrete implementation of the [QuizController] abstract class for handling open-ended question quizzes.
 * Manages the logic, state, and communication related to quizzes where users respond with open-ended answers.
 */
class OpenEndedQuestionController() : QuizController() {

    // The state flow representing the current state of the open-ended quiz.
    private val _state = MutableStateFlow<QuizState.OpenEndedQuizState?>(null)

    // Exposed as a read-only state flow for observing changes in the quiz state.
    val state = _state.asStateFlow()


    // The layout representing the visual presentation of the open-ended quiz.
    override var quizLayout: QuizLayout = OpenEndedQuizLayout

    /**
     * Asynchronously loads the required resources for the open-ended quiz, such as messages and questions.
     * Updates the quiz state based on the loaded resources.
     */
    override fun loadResources() {
        Log.d("Test", "Load Resources called")
        parent.viewModelScope.launch(Dispatchers.IO + parent.exceptionHandler) {

            _screenState.update { QuizState.PossibleState.Loading }
            val conversation = async { retrieveConversation() }.await()


            val question = async { retrieveQuestion() }.await()
            val topicName = parent.module.questionRepository.getTopicName(question.topicUid)
            if (!conversation.any { it.isSystemMessage() }) {
                val instruction = createNewInstruction(question)

                sendInstructionMessage(instruction, onSuccess = {
                    // Update the quiz state with the loaded question and conversation messages.
                    _state.update { QuizState.OpenEndedQuizState(question,  topicName,conversation,) }
                    _screenState.update { QuizState.PossibleState.Default }
                }, onFailure = { _screenState.update { QuizState.PossibleState.FailedToLoad } })
            }

            val metadata = parent.module.questionRepository.getMetadataByQuestionUid(question.uid , parent.module.currentUserUid)
            metadata?.let {
                if(it.status ==QuestionMetadata.COMPLETED)
                    _screenState.update { QuizState.PossibleState.Completed }
            }

            _state.update { QuizState.OpenEndedQuizState(question, parent.module.questionRepository.getTopicName(question.topicUid),conversation,) }
            _screenState.update { QuizState.PossibleState.Default }
            Log.d("Test", _screenState.value.name)
        }
    }

    @OptIn(BetaOpenAI::class)
    private suspend fun sendInstructionMessage(
        instruction: Instruction,
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ) {
        val message = Message(
            quizMetadata.uid,
            instruction.content,
            Message.SYSTEM
        )

        val chatCompletionRequest = ChatCompletionRequestBuilder().build(emptyList(), message)

        parent.module.openAIClient?.let {
            it.sendMessage(chatCompletionRequest).collectLatest {
                it.onSend { Log.d("Test", "Instruction Sent") }.onError {
                    onFailure()
                    throw it
                }.onReceived {
                    Log.d("Test", "Received Instruction")
                    storeMessage(message)
                }.onResponded {
                    onSuccess()
                }
            }
        }
    }

    private fun processResponse(input: String): List<GPTResponse> {
        Log.d("Parser", "Raw input = $input")

        // Extract content between <follow-up> and </follow-up>
        val followUpRegex = Regex("<follow-up>(.*?)</follow-up>")
        val followUpMatches = followUpRegex.findAll(input)

        // Extract content between <suggestion> and </suggestion>
        val suggestionRegex = Regex("<suggestion>(.*?)</suggestion>")
        val suggestionMatches = suggestionRegex.findAll(input)

        // Extract content between <ending> and </ending>
        val endingRegex = Regex("<ending>(.*?)</ending>")
        val endingMatches = endingRegex.findAll(input)

        // Combine matches from all tags into a list
        val allFields = mutableListOf<GPTResponse>()

        followUpMatches.forEach {
            if (it.groupValues.any()) {
                allFields.add(
                    GPTResponse(
                        "follow-up",
                        it.groupValues.first().replace("<follow-up>", "")
                            .replace("</follow-up>", "")
                    )
                )
            }
        }

        for (suggestionMatch in suggestionMatches) {
            if (suggestionMatch.groupValues.any()) {
                allFields.add(
                    GPTResponse(
                        "suggestion",
                        suggestionMatch.groupValues.first().replace("<suggestion>", "")
                            .replace("</suggestion>", "")
                    )
                )
            }
        }

        endingMatches.forEach {
            if (it.groupValues.any()) {
                val endingFieldsRaw =
                    it.groupValues.first().replace("<ending>", "").replace("</ending>", "")
                val endingFields = endingFieldsRaw.split('/')
                if (endingFields.size != 2) {
                    Log.d("Parser", "Ending Tag doesn't contain 2 tags: ${it.groupValues.first()}")
                    allFields.add(GPTResponse("ending", endingFields[0], "10"))
                }
                allFields.add(GPTResponse("ending", endingFields[1], endingFields[0]))
            }
        }

        // Sort the list based on the starting index of each match
        return allFields.ifEmpty { listOf(GPTResponse("follow-up", input)) }
    }


    @OptIn(BetaOpenAI::class)
    private fun createNewInstruction(question: Question): Instruction {
        return parent.module.questionRepository.getInstructionFactory().buildInstruction(
            GPTResponseFormat.DefaultFormat,
            question,
            parent.module.uidGenerator.generateLong(),
            quizMetadata.uid
        )
    }

    /**
     * Returns the read-only state flow representing the current state of the open-ended quiz.
     *
     * @return The [StateFlow] instance.
     */
    override fun presentState(): StateFlow<QuizState?> {
        return state
    }

    /**
     * Handles various quiz events, such as completing the game, receiving new messages from GPT, or user messages.
     * Responds to each event by updating the quiz state and communicating with the [SessionStateManager].
     *
     * @param event The [QuizEvent] representing the occurrence of a quiz-related event.
     */

    override fun onEvent(event: QuizEvent) {
        when (event) {
            is QuizEvent.GameCompleted -> {
                // Notify the parent [SessionStateManager] about the completion of the open-ended quiz.
                _screenState.update { QuizState.PossibleState.Completed }
                parent.onQuizCompleted(quizMetadata, event.finalGrade)
            }

            is QuizEvent.NewChatGptMessage<*> -> {
                val message = when (event.response.type) {
                    "follow-up" -> {
                        Log.d("Parser", "Received Follow Up message")
                        Message(
                            threadUid = quizMetadata.uid,
                            content = event.response.content,
                            sender = Message.BOT
                        )
                    }


                    "suggestion" -> {
                        Log.d("Parser", "Received suggestion  message")
                        Message(
                            threadUid = quizMetadata.uid,
                            content = event.response.content,
                            sender = Message.BOT
                        )
                    }

                    else -> {
                        Log.d("Parser", "Received ending message")
                        onEvent(
                            QuizEvent.GameCompleted(
                                try {
                                    event.response.aux.toDouble()
                                } catch (e: Exception) {
                                    5.0
                                }
                            )
                        )
                        Message(
                            threadUid = quizMetadata.uid,
                            content = event.response.content,
                            sender = Message.BOT
                        )
                    }
                }
                storeMessage(message)
            }

            is QuizEvent.NewUserMessage -> {
                parent.viewModelScope.launch(Dispatchers.IO + parent.exceptionHandler) {

                    val client = parent.module.openAIClient
                        ?: throw NullPointerException("OpenAIClient Is null")
                    val state = _state.value ?: throw NullPointerException("Current State is null")

                    val message = Message(
                        threadUid = quizMetadata.uid,
                        content = event.content,
                        sender = Message.USER
                    )

                    sendMessage(client, state, message)

                }
            }

            else -> {
                // Ignore other events.
            }
        }
    }

    private fun storeMessage(message: Message) {
        // Asynchronously add the message to the conversation repository.
        parent.viewModelScope.launch(Dispatchers.IO + parent.exceptionHandler) {
            parent.module.conversationRepository.addMessage(message).onFailure {
                it.printStackTrace()
                throw it
            }.onSuccess {
                // Update the quiz state with the new message.
                _state.update { it?.copy(conversation = it.conversation + message) }
            }
        }
    }

    @OptIn(BetaOpenAI::class)
    private suspend fun sendMessage(
        openAiClient: OpenAIClient,
        state: QuizState.OpenEndedQuizState,
        message: Message
    ) {
        val instruction = Message(
            quizMetadata.uid,
            createNewInstruction(state.question).content,
            Message.SYSTEM
        )
        val completion = ChatCompletionRequestBuilder().build(
         state.conversation/*+ instruction */, message
        )

        openAiClient.sendMessage(completion).collectLatest { completionState ->
            completionState.onSend {
                storeMessage(message)
            }.onError { error ->
                error.printStackTrace()
                throw error
            }.onReceived {

            }.onResponded { rawResponse ->
                val messages = processResponse(rawResponse)
                Log.d("Parser", "Received ${messages.size} responses from gpt")
                messages.onEach {
                    Log.d("Parser", "Message Content = ${it.content} Aux = ${it.aux}")
                    onEvent(QuizEvent.NewChatGptMessage(it))
                }
            }
        }
    }

    override fun getQuestion(): String {
        return _state.value?.question?.questionContent ?: "Default Question"
    }

    private suspend fun retrieveConversation(): List<Message> {
        return parent.module.conversationRepository.retrieveMessagesForThread(quizMetadata.uid)
    }

    private suspend fun retrieveQuestion(): Question {
        return parent.module.questionRepository.getQuestionByUid(quizMetadata.questionUid)
            ?: throw NullPointerException("No question found")
    }
}
