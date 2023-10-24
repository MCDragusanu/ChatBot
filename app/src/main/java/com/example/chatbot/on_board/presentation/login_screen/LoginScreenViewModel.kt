package com.example.chatbot.on_board.presentation.login_screen

import androidx.lifecycle.ViewModel
import com.example.chatbot.common.SnackbarEvent
import com.example.chatbot.common.TextFieldState
import com.example.chatbot.common.UIState
import com.example.chatbot.on_board.data.module.OnBoardModule
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow

/**
 * An abstract class representing the ViewModel for a login screen in an Android application.
 *
 * This class is intended to manage the state and behavior of a login screen, including email and password input fields, as well
 * as the handling of login-related actions and displaying SnackBar events. It also provides a mechanism to set the `OnBoardModule`
 * for authentication and user management.
 */
abstract class LoginScreenViewModel : ViewModel() {

    // Mutable StateFlows to manage the state of email and password input fields.
    protected val _emailState = MutableStateFlow(TextFieldState())
    val emailState = _emailState.asStateFlow()

    protected val _passwordState = MutableStateFlow(TextFieldState())
    val passwordState = _passwordState.asStateFlow()

    // Channel for delivering SnackBar events.
    protected val _snackbarChannel = Channel<SnackbarEvent>()
    val snackbarChannel = _snackbarChannel.consumeAsFlow()

    protected val _loginBtnState = MutableStateFlow(UIState.Enabled)
    val loginBtnState = _loginBtnState.asStateFlow()

    // Reference to the OnBoardModule, which provides authentication and user management functionality.
    protected lateinit var module: OnBoardModule

    /**
     * Sets the OnBoardModule to be used for authentication and user management.
     *
     * @param module The OnBoardModule instance to be used by this ViewModel.
     */
    fun setModule(module: OnBoardModule) {
        this.module = module
    }

    /**
     * Handles changes in the email input field.
     *
     * @param newEmail The new email value entered by the user.
     */
    abstract fun onEmailChanged(newEmail: String)

    /**
     * Handles changes in the password input field.
     *
     * @param newPassword The new password value entered by the user.
     */
    abstract fun onPasswordChanged(newPassword: String)

    /**
     * Initiates the process to send a password reset email to the provided email address.
     *
     * @param email The email address to which the password reset email will be sent.
     */
    abstract fun sendPasswordResetEmail(email: String)

    /**
     * Emits a SnackBar event to be displayed in the user interface.
     *
     * @param snackbarEvent The event to be displayed in a SnackBar.
     */
    protected abstract fun emitSnackbar(snackbarEvent: SnackbarEvent)

    /**
     * Checks if the provided email and password combination is valid.
     *
     * @param email The email address.
     * @param password The password.
     * @return `true` if the input is valid, `false` otherwise.
     */
    protected abstract fun inputIsValid(email: String, password: String): Boolean

    /**
     * Handles the user's action when the login button is pressed.
     *
     * @param onCompletedLogin A callback function to be invoked when the login operation is successfully completed,
     *                        passing the user's unique identifier.
     */
    abstract fun onLoginIsPressed(onCompletedLogin: (String) -> Unit)
}