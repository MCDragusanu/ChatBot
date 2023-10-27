package com.example.chatbot.on_board.presentation.on_board_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chatbot.common.Destination

abstract class OnBoardScreen : Destination("OnBoardScreen") {
    /**
     * Composable function for the main onboarding screen view.
     *
     * @param viewModel The ViewModel for managing the onboarding screen.
     * @param onRegister A callback function to navigate to the registration screen or perform registration-related actions.
     */
    @Composable
    abstract fun Main(viewModel: OnBoardViewModel, onRegister: () -> Unit)

    /**
     * Composable function for the features carousel.
     *
     * @param modifier The modifier to apply to the Composable element.
     * @param onItemChanges A callback function to handle changes in the currently displayed item within the carousel.
     */
    @Composable
    abstract fun FeaturesCarousel(modifier: Modifier, onItemChanges: (Int) -> Unit)

    /**
     * Composable function for the "Register" button.
     *
     * @param modifier The modifier to apply to the Composable element.
     * @param onClick A callback function to handle the click event of the "Register" button.
     */
    @Composable
    abstract fun RegisterButton(modifier: Modifier, onClick: () -> Unit)
}