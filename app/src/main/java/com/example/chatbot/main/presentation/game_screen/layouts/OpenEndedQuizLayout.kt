package com.example.chatbot.main.presentation.game_screen.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.chatbot.common.ui.util.Destination
import com.example.chatbot.main.presentation.game_screen.controllers.QuizController
import com.example.chatbot.main.presentation.game_screen.model.QuizState

/**
 * Object representing the layout for the OpenEndedQuizScreen destination.
 * Implements the [QuizLayout] interface to define the visual presentation for open-ended question quizzes.
 * This object is used in conjunction with a [QuizController] to compose the UI and handle user interactions.
 */
object OpenEndedQuizLayout : Destination("OpenEndedQuizScreen"), QuizLayout {

    /**
     * Composable function to invoke the OpenEndedQuizLayout and compose the UI based on the quiz state.
     *
     * @param controller The [QuizController] associated with the open-ended question quiz.
     * @param onCompletion Callback function to be executed when the quiz is completed.
     */
    @Composable
    override fun invoke(controller: QuizController, onCompletion: () -> Unit) {
        // Collect the current state of the open-ended quiz from the controller's state flow.
        val _state by controller.presentState().collectAsState()

        // Safely cast the state to the specific type for open-ended quizzes.
        val currentState = _state as QuizState.OpenEndedQuizState?

        // Use the currentState to determine the content and behavior of the open-ended quiz screen.
        currentState?.let {
            // TODO: Implement UI composition based on the currentState and handle user interactions.
            // You can access the question, conversation, and other information from currentState.
            // Optionally, call onCompletion when the quiz is completed.
        }
    }
}
