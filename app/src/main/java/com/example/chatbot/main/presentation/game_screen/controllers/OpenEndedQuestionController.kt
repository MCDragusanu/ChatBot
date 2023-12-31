package com.example.chatbot.main.presentation.game_screen.controllers

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.chatbot.main.data.database_messages.model.Message
import com.example.chatbot.main.presentation.game_screen.model.QuizEvent
import com.example.chatbot.main.presentation.game_screen.model.QuizState
import com.example.chatbot.main.presentation.game_screen.layouts.OpenEndedQuizLayout
import com.example.chatbot.main.presentation.game_screen.layouts.QuizLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

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
        parent.viewModelScope.launch(Dispatchers.IO + parent.exceptionHandler) {
            val conversation =
                parent.module.conversationRepository.retrieveMessagesForThread(quizMetadata.uid)
            val question =
                parent.module.questionRepository.getQuestionByUid(quizMetadata.questionUid)
                    ?: throw NullPointerException("No question found")

            // Log conversation messages for debugging purposes.
            conversation.onEach {
                Log.d(
                    "Test",
                    "${if (it.isSentByUser()) "User : " else if (it.isSentByGPT()) "GPT : " else "System : "} ${it.content}}\n"
                )
            }

            // Update the quiz state with the loaded question and conversation messages.
            _state.update { QuizState.OpenEndedQuizState(question, conversation) }
        }
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
                parent.onQuizCompleted(quizMetadata.uid)
            }

            is QuizEvent.NewChatGptMessage<*> -> {
                // Create a new message from GPT and add it to the conversation.
                val message = Message(
                    parent.module.uidGenerator.generateLong(),
                    threadUid = quizMetadata.uid,
                    content = event.response.message,
                    sender = Message.BOT
                )

                // Asynchronously add the message to the conversation repository.
                parent.viewModelScope.launch(Dispatchers.IO + parent.exceptionHandler) {
                    parent.module.conversationRepository.addMessage(message).onFailure {
                        throw it
                    }.onSuccess {
                        // Update the quiz state with the new message.
                        _state.update { it?.copy(conversation = it.conversation + message) }
                    }
                }
            }

            is QuizEvent.NewUserMessage -> {
                // Create a new user message and add it to the conversation.
                val message = Message(
                    parent.module.uidGenerator.generateLong(),
                    threadUid = quizMetadata.uid,
                    content = event.content,
                    sender = Message.USER
                )

                // Asynchronously add the user message to the conversation repository.
                parent.viewModelScope.launch(Dispatchers.IO + parent.exceptionHandler) {
                    parent.module.conversationRepository.addMessage(message).onFailure {
                        throw it
                    }.onSuccess {
                        // Update the quiz state with the new user message.
                        _state.update { it?.copy(conversation = it.conversation + message) }
                    }
                }
            }

            else -> {
                // Ignore other events.
            }
        }
    }
}
