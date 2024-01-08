package com.example.chatbot.main.presentation.game_screen.layouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chatbot.main.presentation.game_screen.controllers.QuizController

/**
 * Interface defining the contract for the layout of a quiz screen.
 * Implementing classes or objects should provide a composable function to render the visual presentation of a quiz.
 */
interface QuizLayout {

    /**
     * Composable function to render the visual presentation of a quiz based on the provided quiz controller.
     *
     * @param controller The [QuizController] associated with the quiz.
     * @param onCompletion Callback function to be executed when the quiz is completed.
     */
    @Composable
    operator fun invoke(modifier : Modifier,questionIndex:Int, controller: QuizController, onCompletion: () -> Unit)
}
