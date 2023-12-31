package com.example.chatbot.main.presentation.game_screen.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.chatbot.common.ui.util.Destination
import com.example.chatbot.main.presentation.game_screen.controllers.QuizController
import com.example.chatbot.main.presentation.game_screen.model.QuizState
import kotlinx.coroutines.flow.map

/**
 * Object representing the layout for the MultiChoiceQuizScreen destination.
 * Implements the [QuizLayout] interface to define the visual presentation for multi-choice quizzes.
 * This object is used in conjunction with a [QuizController] to compose the UI and handle user interactions.
 */
object MultiChoiceQuizLayout : Destination("MultiChoiceQuizScreen"), QuizLayout {

    /**
     * Composable function to invoke the MultiChoiceQuizLayout and compose the UI based on the quiz state.
     *
     * @param controller The [QuizController] associated with the multi-choice quiz.
     * @param onCompletion Callback function to be executed when the quiz is completed.
     */
    @Composable
    override fun invoke(controller: QuizController, onCompletion: () -> Unit) {
        // Collect the current state of the multi-choice quiz from the controller's state flow.
        val _state by controller.presentState().collectAsState()

        // Safely cast the state to the specific type for multi-choice quizzes.
        val currentState = _state as QuizState.MultiChoiceQuizState?

        // TODO: Implement UI composition based on the currentState and handle user interactions.
        // Use the currentState to determine the content and behavior of the multi-choice quiz screen.
        // Optionally, call onCompletion when the quiz is completed.
    }
}