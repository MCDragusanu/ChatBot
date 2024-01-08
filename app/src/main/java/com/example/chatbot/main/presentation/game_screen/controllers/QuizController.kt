package com.example.chatbot.main.presentation.game_screen.controllers

import com.example.chatbot.main.data.database_messages.model.QuizMetadata
import com.example.chatbot.main.presentation.game_screen.model.QuizEvent
import com.example.chatbot.main.presentation.game_screen.model.QuizState
import com.example.chatbot.main.presentation.game_screen.state_manager.SessionStateManager
import com.example.chatbot.main.presentation.game_screen.layouts.QuizLayout
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class QuizController {



    /**
     * The parent [SessionStateManager] responsible for managing the overall session state.
     */
    protected lateinit var parent: SessionStateManager

    /**
     * The metadata associated with the quiz, providing information about the quiz type and settings.
     */
    protected lateinit var quizMetadata: QuizMetadata

    /**
     * The layout representing the visual presentation of the quiz.
     */
    protected abstract var quizLayout: QuizLayout

    protected val _screenState = MutableStateFlow(QuizState.PossibleState.Default)
    val screenState = _screenState.asStateFlow()
    /**
     * Sets the parent [SessionStateManager] for this controller.
     *
     * @param parent The [SessionStateManager] instance.
     */
    fun setListener(parent: SessionStateManager) {
        this.parent = parent
    }

    /**
     * Sets the quiz metadata for this controller.
     *
     * @param metadata The [QuizMetadata] instance providing information about the quiz.
     */
    fun setThreadMetadata(metadata: QuizMetadata) {
        this.quizMetadata = metadata
    }

    /**
     * Abstract method to load resources required for the quiz. Concrete implementations should handle
     * loading data, messages, or any other resources needed for the quiz.
     */
    abstract fun loadResources()

    /**
     * Abstract method to present the current state of the quiz.
     *
     * @return A [StateFlow] representing the current state of the quiz.
     */
    abstract fun presentState(): StateFlow<QuizState?>

    /**
     * Abstract method to handle quiz events, such as user interactions or system events.
     *
     * @param event The [QuizEvent] representing the occurrence of a quiz-related event.
     */
    abstract fun onEvent(event: QuizEvent)

    /**
     * Returns the layout representing the visual presentation of the quiz.
     *
     * @return The [QuizLayout] instance.
     */
    fun getLayout() = quizLayout
    abstract fun getQuestion(): String
}