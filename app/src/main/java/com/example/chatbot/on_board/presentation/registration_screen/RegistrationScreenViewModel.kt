package com.example.chatbot.on_board.presentation.registration_screen

import androidx.lifecycle.ViewModel
import com.example.chatbot.common.ui.util.SnackbarEvent
import com.example.chatbot.common.ui.util.TextFieldState
import com.example.chatbot.common.ui.util.UIState
import com.example.chatbot.on_board.data.module.OnBoardModule
import com.example.chatbot.on_board.domain.EmailValidator
import com.example.chatbot.on_board.domain.EmailValidatorImpl
import com.example.chatbot.on_board.domain.PasswordValidator
import com.example.chatbot.on_board.domain.PasswordValidatorImpl
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow

/**
 * An abstract ViewModel class for the registration screen, responsible for managing the UI state and user interactions during registration.
 */
abstract class RegistrationScreenViewModel() : ViewModel() {



    protected val _occupationFieldState =  MutableStateFlow(TextFieldState())
    val occupationFieldState = _occupationFieldState.asStateFlow()

    protected val _lastNameFieldState = MutableStateFlow(TextFieldState())
    val lastNameFieldState = _lastNameFieldState.asStateFlow()

    protected val _firstNameFieldState = MutableStateFlow(TextFieldState())
    val firstNameFieldState = _lastNameFieldState.asStateFlow()

    // State flows for email, password, terms, and UI components.
    protected val _emailFieldState = MutableStateFlow(TextFieldState())
    val emailFieldState = _emailFieldState.asStateFlow()

    protected val _passwordFieldState = MutableStateFlow(TextFieldState())
    val passwordFieldState = _passwordFieldState.asStateFlow()

    protected val _termsState = MutableStateFlow(UIState.Enabled)
    val termsState = _termsState.asStateFlow()

    protected val _termsIsChecked = MutableStateFlow(false)
    val termsIsChecked = _termsIsChecked.asStateFlow()

    protected val _snackbarChannel = Channel<SnackbarEvent>()
    val snackbarChannel = _snackbarChannel.consumeAsFlow()

    protected val _btnRegister = MutableStateFlow(UIState.Enabled)
    val btnRegister = _btnRegister.asStateFlow()

    protected val passwordValidator:PasswordValidator = PasswordValidatorImpl
    protected val emailValidator:EmailValidator = EmailValidatorImpl

    protected lateinit var module: OnBoardModule

    /**
     * Set the OnBoardModule to be used for registration and user management.
     *
     * @param onBoardModule The OnBoardModule instance to be used by this ViewModel.
     */
    fun initModule(onBoardModule: OnBoardModule) {
        this.module = onBoardModule
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
     * Handles changes in the "Terms and Conditions" checkbox.
     *
     * @param boolean The new state of the checkbox (checked or unchecked).
     */
    abstract fun onTermsChanged(boolean: Boolean)

    /**
     * Initiates the registration process.
     *
     * @param onCompletedRegistration A callback function to be invoked when the registration is successfully completed,
     * passing the user's unique identifier.
     */
    abstract fun onRegister(onCompletedRegistration: (String) -> Unit)

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
    protected abstract fun inputIsValid(email: String, password: String , termsIsChecked:Boolean): Boolean

    /**
     * Handles errors that may occur during the registration process.
     *
     * @param exception The exception representing the error.
     */
    protected abstract fun onError(exception: Exception)
    abstract fun onFirstNameChanged(newFirstName : String)


    abstract fun onOccupationChanged(newOccupation: String)
    abstract fun onLastNameChanged(newLastName : String)

}