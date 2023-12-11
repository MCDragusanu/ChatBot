package com.example.chatbot.on_board.presentation.registration_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chatbot.common.ui.util.Destination
import com.example.chatbot.common.ui.util.TextFieldState
import com.example.chatbot.common.ui.util.UIState
import kotlinx.coroutines.flow.StateFlow

/**
 * An abstract class representing a registration screen with Jetpack Compose components and related functionality.
 *
 * This class extends the [Destination] class and serves as the destination identifier for the registration screen within a navigation graph.
 */
abstract class RegistrationScreen : Destination("RegistrationScreen") {
    /**
     * Composable function for the main registration screen view.
     *
     * @param viewModel The ViewModel for managing the registration screen.
     * @param onCompletedRegistration A callback function to be invoked when the registration is successfully completed,
     *                              passing the user's unique identifier.
     */
    @Composable
    abstract fun Main(
        viewModel: RegistrationScreenViewModel,
        onCompletedRegistration: (String) -> Unit
    )

    /**
     * Composable function for the email input field.
     *
     * @param modifier The modifier to apply to the Composable element.
     * @param textFieldState A StateFlow representing the state of the email input field.
     * @param onValueChanged A callback function to handle changes in the email input value.
     */
    @Composable
    abstract fun EmailTextField(
        modifier: Modifier,
        textFieldState: StateFlow<TextFieldState>,
        onValueChanged: (String) -> Unit,
    )

    /**
     * Composable function for the password input field.
     *
     * @param modifier The modifier to apply to the Composable element.
     * @param textFieldState A StateFlow representing the state of the password input field.
     * @param onValueChanged A callback function to handle changes in the password input value.
     */
    @Composable
    abstract fun PasswordTextField(
        modifier: Modifier,
        textFieldState: StateFlow<TextFieldState>,
        onValueChanged: (String) -> Unit,
    )

    /**
     * Composable function for the "Terms of Use" checkbox.
     *
     * @param modifier The modifier to apply to the Composable element.
     * @param state A StateFlow representing the state of the checkbox (checked or unchecked).
     * @param onStateChanged A callback function to handle changes in the checkbox state.
     */
    @Composable
    abstract fun TermsOfUseCheckBox(
        modifier: Modifier,
        state: StateFlow<Boolean>,
        onStateChanged: (Boolean) -> Unit
    )

    /**
     * Composable function for the "Terms of Use" dialog, which provides options for acceptance or rejection.
     *
     * @param onDismiss A callback function to handle the dialog dismissal.
     * @param onRejected A callback function to handle the rejection of terms.
     * @param onAccepted A callback function to handle the acceptance of terms.
     */
    @Composable
    abstract fun TermsOfUseDialog(
        onDismiss: () -> Unit,
        onRejected: () -> Unit,
        onAccepted: () -> Unit
    )
    @Composable
    abstract fun Headline()

    /**
     * Composable function for the "Forgot Password" button.
     *
     * @param modifier The modifier to apply to the Composable element.
     * @param onClick A callback function to handle the click event of the "Forgot Password" button.
     */
    @Composable
    abstract fun RegisterButton(modifier: Modifier, onClick: () -> Unit)



}