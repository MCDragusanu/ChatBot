package com.example.chatbot.on_board.presentation.login_screen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.example.chatbot.R
import com.example.chatbot.common.services.account_manager.AccountErrors
import com.example.chatbot.common.ui.util.SnackbarEvent
import com.example.chatbot.common.ui.util.UIState
import com.example.chatbot.main.domain.use_cases.SyncronizeQuestions
import com.example.chatbot.main.domain.use_cases.SyncronizeTopics
import com.example.chatbot.on_board.data.auth.AuthError
import com.example.chatbot.on_board.domain.EmailValidator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.format.TextStyle

class LoginScreenViewModelImpl:LoginScreenViewModel() {

    override fun onEmailChanged(newEmail: String) {

        this._emailState.update { it.copy(content = newEmail) }
    }

    override fun onPasswordChanged(newPassword: String) {
        this._passwordState.update { it.copy(content = newPassword) }
    }

    override fun sendPasswordResetEmail(onCompleted: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            //Reset and save the state of the text field when submiting email
            _passwordResetEmailField.update {
                it.copy(
                    content = _passwordResetEmailField.value.content,
                    errorCode = null,
                    state = UIState.Enabled
                )
            }

            //Put button in Loading State
            _passwordResetButton.update { UIState.Loading }

            //Check the email if is valid
            val emailIsValid =
                emailValidator.check(_passwordResetEmailField.value.content) == EmailValidator.Result.Valid

            if (!emailIsValid) {
                //Update the email field to display the error
                _passwordResetEmailField.update {
                    it.copy(
                        content = _passwordResetEmailField.value.content,
                        errorCode = R.string.error_invalid_email_format,
                        state = UIState.Error
                    )
                }

                //Update the button to error state
                _passwordResetButton.update { UIState.Error }

                //quit executing
                return@launch
            }
            module.accountManager.sendPasswordResetEmail(_passwordResetEmailField.value.content).onFailure { error ->
                onResetPasswordError(error)

            }.onSuccess {
                //put text field and button in completed state
                _passwordResetEmailField.update { it.copy(state = UIState.Completed, errorCode = null) }
                _passwordResetButton.update { UIState.Completed }
                //update the email field with this value for better user experience
                //so that the user won't have to enter again
                _emailState.update { it.copy(_passwordResetEmailField.value.content) }

                //send a confirmation snackbar
                emitSnackbar(SnackbarEvent("Email Sent" , eventType = SnackbarEvent.EventType.Confirmation))
                onCompleted()
            }
        }
    }

    override fun emitSnackbar(snackbarEvent: SnackbarEvent) {
        //we have to use viewModel scope because it is a suspend function
        viewModelScope.launch {
            _snackbarChannel.send(snackbarEvent)
        }
    }

    override fun inputIsValid(email: String, password: String): Boolean {

        //checking if the email is empty
        if (email.isEmpty()) {
            _emailState.update { it.copy(errorCode = R.string.error_email_not_provied, state = UIState.Error) }
            _loginBtnState.update { UIState.Error }
            return false
        }
        // we only care if the password is empty to avoid sending requests that are obvious that are going to fail
        if (password.isEmpty()) {
            _passwordState.update { it.copy(errorCode = R.string.error_password_not_provided, state = UIState.Error) }
            _loginBtnState.update { UIState.Error }
            return false
        }

        val emailIsValid = emailValidator.check(email) == EmailValidator.Result.Valid

        Log.d("Test" , "emailState = $emailIsValid")

        if(!emailIsValid){
            _emailState.update { it.copy(errorCode = R.string.error_invalid_email_format , state = UIState.Error) }
        }
        //We only care about the email because the backend will check if the password is correct (when sending the request to the server for auth )
        return emailIsValid

    }

    override fun onLoginIsPressed(onCompletedLogin: (String) -> Unit) {

        //resetting state for password field
        _passwordState.update { it.copy(errorCode = null, state = UIState.Enabled) }

        //resetting state for email field
        _emailState.update { it.copy(errorCode = null, state = UIState.Enabled) }

        //checking the text fields input
        val inputIsValid = inputIsValid(_emailState.value.content, passwordState.value.content)

        //we only start the login process if the input is valid
        if (inputIsValid) viewModelScope.launch(Dispatchers.IO) {
            //putting loginButton in loading state
            _loginBtnState.update { UIState.Loading }

            module.authService.loginUser(_emailState.value.content, _passwordState.value.content)
                .onFailure { onLoginError(it) }
                .onSuccess {uid->

                    _emailState.update { it.copy(state = UIState.Completed, errorCode = null) }

                    _passwordState.update { it.copy(state = UIState.Completed, errorCode = null) }

                    _loginBtnState.update { UIState.Completed }

                    viewModelScope.launch(Dispatchers.IO){
                        SyncronizeQuestions.execute(
                            module.cloudDataSource,
                            uid,
                            module.dataSource,
                            module.questionRepository,
                            this
                        )
                        SyncronizeTopics.execute(
                            module.cloudDataSource,
                            module.dataSource,
                            module.questionRepository,
                            this
                        )
                    }.invokeOnCompletion {
                        viewModelScope.launch(Dispatchers.Main) {

                            onCompletedLogin(uid)
                        }
                    }
                    // Switching context because current one is set to IO .
                    // onCompletedLogin will be called from UI Layer which will cause an error beacause UI must run only in Main context

                }
        }
    }

    override fun onResetPasswordEmaiLChanged(email: String) {
        _passwordResetEmailField.update { it.copy(content = email) }
    }

    override fun onLoginError(exception: AuthError) {
        val snackbar = when (exception) {
            is AuthError.InvalidCredentials -> {
                //only necessary to display once the error message
                _emailState.update { it.copy(errorCode = R.string.error_invalid_credentials, state = UIState.Error) }
                _passwordState.update { it.copy(state = UIState.Error) }
                SnackbarEvent(
                    exception.message ?: "Unknown Error has occurred while logging in",
                    SnackbarEvent.EventType.Error
                )
            }

            is AuthError.InvalidEmailFormat -> {
                //Only change the email field because the password is not related to this error
                _emailState.update { it.copy(errorCode = R.string.error_invalid_credentials, state = UIState.Error) }
                SnackbarEvent(
                    exception.message ?: "Unknown Error has occurred while logging in",
                    SnackbarEvent.EventType.Error
                )
            }

            is AuthError.UnknownError -> {
                SnackbarEvent(
                    exception.message ?: "Unknown Error has occurred while logging in",
                    SnackbarEvent.EventType.Error
                )
            }

            is AuthError.UserUidNotFound -> {
                //this is an internal error that is 99.99999999% not going to happen
                SnackbarEvent(
                    exception.message ?: "Unknown Error has occurred while logging in",
                    SnackbarEvent.EventType.Error
                )
            }

            is AuthError.PasswordTooWeak -> {
                //This error will only be possible when creating account not now
                SnackbarEvent(
                    exception.message ?: "Unknown Error has occurred while logging in",
                    SnackbarEvent.EventType.Error
                )
            }

            is AuthError.UserCollision -> {
                //This error will only be possible when creating account not now
                SnackbarEvent(
                    exception.message ?: "Unknown Error has occurred while logging in",
                    SnackbarEvent.EventType.Error
                )
            }
        }
        //Updating the state of the button
        _loginBtnState.update { UIState.Error }
        //emitting the snackbar
        emitSnackbar(snackbar)
    }

    override fun onResetPasswordError(error: AccountErrors) {
        //creating a snackbar with the error message
        val snackbar = when (error) {
            //identify what type of error it is
            is AccountErrors.UnknownError -> {
                SnackbarEvent(message = error.errorMessage, eventType = SnackbarEvent.EventType.Error)
            }

            is AccountErrors.InvalidEmail -> {
                //update the text field because it is an email-related error
                _passwordResetEmailField.update {
                    it.copy(
                        errorCode = R.string.error_invalid_email_format,
                        state = UIState.Error
                    )
                }
                SnackbarEvent(
                    message = error.localizedMessage
                        ?: "Unknown Error has occurred when seding password reset email",
                    eventType = SnackbarEvent.EventType.Error
                )

            }

            is AccountErrors.NoUserFound -> {
                //update the text field because it is an email-related error
                _passwordResetEmailField.update {
                    it.copy(
                        errorCode = R.string.error_no_user_found,
                        state = UIState.Error
                    )
                }
                SnackbarEvent(
                    message = "There is no active user linked to this email",
                    eventType = SnackbarEvent.EventType.Error
                )
            }

            is AccountErrors.ReauthRequired -> {
                SnackbarEvent(
                    message = error.localizedMessage
                        ?: "Unknown Error has occurred when sending password reset email",
                    eventType = SnackbarEvent.EventType.Error
                )
            }

        }
        //updating the button with error state
        _passwordResetButton.update { UIState.Error }
        //emitting the error snackbar
        emitSnackbar(snackbar)
    }
}