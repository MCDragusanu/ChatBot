package com.example.chatbot.main.presentation.game_screen.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    override fun invoke(modifier: Modifier, questionIndex:Int,controller: QuizController, onCompletion: () -> Unit) {
        // Collect the current state of the multi-choice quiz from the controller's state flow.
        val _state by controller.presentState().collectAsState()

        // Safely cast the state to the specific type for multi-choice quizzes.
        val currentState = _state as QuizState.MultiChoiceQuizState?


        LaunchedEffect(key1 = true){
            controller.loadResources()
        }

    }
}