package com.example.chatbot.main.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot.main.data.database_messages.model.SessionMetadata
import com.example.chatbot.main.data.module.MainModule
import com.example.chatbot.main.data.database_questions.entity.TopicMetadata
import com.example.chatbot.main.domain.pre_defined_questions.predefinedTopics
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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
    private val _recentSessions = MutableStateFlow(provideTestSessions())
    val recentSessions = _recentSessions.asStateFlow()

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
        }
    }

    private fun provideTestSessions() = listOf(
        SessionMetadata(
            Random().nextLong().absoluteValue,
            userUid = "DEFAULT_USER",
            timestamp = Date().time,
            status = Random().nextInt().absoluteValue % 3,
            topicsUids = buildString {
                val randomTopics =
                    predefinedTopics.subList(
                        0,
                        Random().nextInt().absoluteValue % predefinedTopics.size
                    )
                        .map { it.uid }
                randomTopics.onEachIndexed { index, i ->
                    if (index != randomTopics.lastIndex) {
                        append(i)
                        append("/")
                    } else append(i)
                }
            }),
        SessionMetadata(
            Random().nextLong().absoluteValue,
            userUid = "DEFAULT_USER",
            timestamp = Date().time,
            status = Random().nextInt().absoluteValue % 3,
            topicsUids = buildString {
                val randomTopics =
                    predefinedTopics.subList(
                        0,
                        Random().nextInt().absoluteValue % predefinedTopics.size
                    )
                        .map { it.uid }
                randomTopics.onEachIndexed { index, i ->
                    if (index != randomTopics.lastIndex) {
                        append(i)
                        append("/")
                    } else append(i)
                }
            }),
        SessionMetadata(
            Random().nextLong().absoluteValue,
            userUid = "DEFAULT_USER",
            timestamp = Date().time,
            status = Random().nextInt().absoluteValue % 3,
            topicsUids = buildString {
                val randomTopics =
                    predefinedTopics.subList(
                        0,
                        Random().nextInt().absoluteValue % predefinedTopics.size
                    )
                        .map { it.uid }
                randomTopics.onEachIndexed { index, i ->
                    if (index != randomTopics.lastIndex) {
                        append(i)
                        append("/")
                    } else append(i)
                }
            }),
        SessionMetadata(
            Random().nextLong().absoluteValue,
            userUid = "DEFAULT_USER",
            timestamp = Date().time,
            status = Random().nextInt().absoluteValue % 3,
            topicsUids = buildString {
                val randomTopics =
                    predefinedTopics.subList(
                        0,
                        Random().nextInt().absoluteValue % predefinedTopics.size
                    )
                        .map { it.uid }
                randomTopics.onEachIndexed { index, i ->
                    if (index != randomTopics.lastIndex) {
                        append(i)
                        append("/")
                    } else append(i)
                }
            }),
        SessionMetadata(
            Random().nextLong().absoluteValue,
            userUid = "DEFAULT_USER",
            timestamp = Date().time,
            status = Random().nextInt().absoluteValue % 3,
            topicsUids = buildString {
                val randomTopics =
                    predefinedTopics.subList(
                        0,
                        Random().nextInt().absoluteValue % predefinedTopics.size
                    )
                        .map { it.uid }
                randomTopics.onEachIndexed { index, i ->
                    if (index != randomTopics.lastIndex) {
                        append(i)
                        append("/")
                    } else append(i)
                }
            }),
        SessionMetadata(
            Random().nextLong().absoluteValue,
            userUid = "DEFAULT_USER",
            timestamp = Date().time,
            status = Random().nextInt().absoluteValue % 3,
            topicsUids = buildString {
                val randomTopics =
                    predefinedTopics.subList(
                        0,
                        Random().nextInt().absoluteValue % predefinedTopics.size
                    )
                        .map { it.uid }
                randomTopics.onEachIndexed { index, i ->
                    if (index != randomTopics.lastIndex) {
                        append(i)
                        append("/")
                    } else append(i)
                }
            }),
        SessionMetadata(
            Random().nextLong().absoluteValue,
            userUid = "DEFAULT_USER",
            timestamp = Date().time,
            status = Random().nextInt().absoluteValue % 3,
            topicsUids = buildString {
                val randomTopics =
                    predefinedTopics.subList(
                        0,
                        Random().nextInt().absoluteValue % predefinedTopics.size
                    )
                        .map { it.uid }
                randomTopics.onEachIndexed { index, i ->
                    if (index != randomTopics.lastIndex) {
                        append(i)
                        append("/")
                    } else append(i)
                }
            }),
        SessionMetadata(
            Random().nextLong().absoluteValue,
            userUid = "DEFAULT_USER",
            timestamp = Date().time,
            status = Random().nextInt().absoluteValue % 3,
            topicsUids = buildString {
                val randomTopics =
                    predefinedTopics.subList(
                        0,
                        Random().nextInt().absoluteValue % predefinedTopics.size
                    )
                        .map { it.uid }
                randomTopics.onEachIndexed { index, i ->
                    if (index != randomTopics.lastIndex) {
                        append(i)
                        append("/")
                    } else append(i)
                }
            }),
        SessionMetadata(
            Random().nextLong().absoluteValue,
            userUid = "DEFAULT_USER",
            timestamp = Date().time,
            status = Random().nextInt().absoluteValue % 3,
            topicsUids = buildString {
                val randomTopics =
                    predefinedTopics.subList(
                        0,
                        Random().nextInt().absoluteValue % predefinedTopics.size
                    )
                        .map { it.uid }
                randomTopics.onEachIndexed { index, i ->
                    if (index != randomTopics.lastIndex) {
                        append(i)
                        append("/")
                    } else append(i)
                }
            })

    )

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

    // Function to get topic labels based on a string containing topic UIDs.
    fun getTopicsLabel(s: String): List<String> {
        // Split the input string into a list of topic UIDs and filter out blank entries.
        val ids = s.split('/').filter { it.isNotBlank() }.map { it.toInt() }

        // Return the labels of predefined topics whose UIDs match the extracted IDs.
        return predefinedTopics.filter { it.uid in ids }.map { it.label }
    }
}