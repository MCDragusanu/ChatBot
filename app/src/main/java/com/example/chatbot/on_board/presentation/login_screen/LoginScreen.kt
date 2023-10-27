package com.example.chatbot.on_board.presentation.login_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chatbot.common.Destination
import com.example.chatbot.common.TextFieldState
import com.example.chatbot.common.UIState
import kotlinx.coroutines.flow.StateFlow

/**
 * An interface defining the structure and behavior of a login screen Composable.
 */
/**
 * An abstract class representing a login screen with Jetpack Compose components and related functionality.
 *
 * This class extends the [Destination] class and serves as the destination identifier for the login screen within a navigation graph.
 */
abstract class LoginScreen : Destination("LoginScreen") {
    /**
     * Composable function for the main login screen view.
     *
     * @param viewModel The ViewModel for managing the login screen.
     * @param onLoginCompleted A callback function to be invoked when the login is successfully completed, passing the user's unique identifier.
     * @param onRegister A callback function to navigate to the registration screen or perform registration-related actions.
     */
    @Composable
    abstract fun Main(
        viewModel: LoginScreenViewModel,
        onLoginCompleted: (String) -> Unit,
        onRegister: () -> Unit
    )

    /**
     * Composable function for the email input field.
     *
     * @param modifier The modifier to apply to the Composable element.
     * @param state A StateFlow representing the state of the email input field.
     * @param onValueChanged A callback function to handle changes in the email input value.
     */
    @Composable
    abstract fun EmailTextField(
        modifier: Modifier,
        state: StateFlow<TextFieldState>,
        onValueChanged: (String) -> Unit
    )

    /**
     * Composable function for the password input field.
     *
     * @param modifier The modifier to apply to the Composable element.
     * @param state A StateFlow representing the state of the password input field.
     * @param onValueChanged A callback function to handle changes in the password input value.
     */
    @Composable
    abstract fun PasswordTextField(
        modifier: Modifier,
        state: StateFlow<TextFieldState>,
        onValueChanged: (String) -> Unit
    )

    /**
     * Composable function for the login button.
     *
     * @param modifier The modifier to apply to the Composable element.
     * @param state A StateFlow representing the state of the login button.
     * @param onClick A callback function to handle the click event of the login button.
     */
    @Composable
    abstract fun LoginButton(
        modifier: Modifier,
        state: StateFlow<UIState>,
        onClick: () -> Unit
    )

    /**
     * Composable function for the "Forgot Password" button.
     *
     * @param modifier The modifier to apply to the Composable element.
     * @param onClick A callback function to handle the click event of the "Forgot Password" button.
     */
    @Composable
    abstract fun ForgotPasswordButton(modifier: Modifier, onClick: () -> Unit)

    /**
     * Composable function for the "Forgot Password" dialog, which includes an email input field and a button to send a password reset email.
     *
     * @param modifier The modifier to apply to the Composable element.
     * @param emailFieldState A StateFlow representing the state of the email input field.
     * @param sendResetPasswordEmailButtonState A StateFlow representing the state of the send password reset email button.
     * @param onSendEmail A callback function to send a password reset email.
     */
    @Composable
    abstract fun ForgotPasswordDialog(
        modifier: Modifier,
        emailFieldState: StateFlow<TextFieldState>,
        sendResetPasswordEmailButtonState: StateFlow<UIState>,
        onSendEmail: (String) -> Unit
    )
}

