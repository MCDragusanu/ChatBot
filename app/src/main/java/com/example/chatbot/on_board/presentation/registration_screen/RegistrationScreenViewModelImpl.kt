package com.example.chatbot.on_board.presentation.registration_screen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.chatbot.R
import com.example.chatbot.common.databases.user_database.User
import com.example.chatbot.common.ui.util.SnackbarEvent
import com.example.chatbot.common.ui.util.UIState
import com.example.chatbot.main.data.database_questions.local.QuestionRepository
import com.example.chatbot.main.domain.use_cases.SyncronizeQuestions
import com.example.chatbot.main.domain.use_cases.SyncronizeTopics
import com.example.chatbot.on_board.data.auth.AuthError
import com.example.chatbot.on_board.domain.EmailValidator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date

class RegistrationScreenViewModelImpl:RegistrationScreenViewModel() {

    override fun onEmailChanged(newEmail: String) {
       this._emailFieldState.update { it.copy(content = newEmail) }
          }

    override fun onPasswordChanged(newPassword: String) {
        this._passwordFieldState.update { it.copy(content = newPassword) }
    }

    override fun onTermsChanged(boolean: Boolean) {
        this._termsIsChecked.update { boolean }
    }

    override fun onFirstNameChanged(newFirstName: String) {
        this._firstNameFieldState.update { it.copy(content = newFirstName) }
    }
    override fun onLastNameChanged(newLastName: String) {
        this._lastNameFieldState.update { it.copy(content = newLastName) }
    }

    override fun onOccupationChanged(newOccupation: String) {
        this._occupationFieldState.update { it.copy(content = newOccupation) }
    }
    override fun onRegister(onCompletedRegistration: (String) -> Unit) {
        //resetting state for password field
        _passwordFieldState.update { it.copy(errorCode = null, state = UIState.Enabled) }

        //resetting state for email field
        _emailFieldState.update { it.copy(errorCode = null, state = UIState.Enabled) }

        //checking the text fields input
        val inputIsValid = inputIsValid(
            _emailFieldState.value.content,
            passwordFieldState.value.content,
            _termsIsChecked.value
        )

        //we only start the registration process if the input is valid
        if (inputIsValid) viewModelScope.launch(Dispatchers.IO) {
            //putting btnRegister in loading state
            _btnRegister.update { UIState.Loading }

            module.authService.registerUser(
                _emailFieldState.value.content,
                _passwordFieldState.value.content
            )
                .onFailure { onError(it) }
                .onSuccess {uid->

                    _emailFieldState.update { it.copy(state = UIState.Completed, errorCode = null) }

                    _passwordFieldState.update {
                        it.copy(
                            state = UIState.Completed,
                            errorCode = null
                        )
                    }

                    _btnRegister.update { UIState.Completed }

                    val user = User(
                        uid = uid,
                        email = _emailFieldState.value.content,
                        firstName = _firstNameFieldState.value.content,
                        lastName = _lastNameFieldState.value.content,
                        isEmailVerified = false,
                        occupation = _occupationFieldState.value.content,
                        dateOfCreation = Date().toString()
                    )
                    viewModelScope.launch(Dispatchers.IO) {
                        module.userRepository.addUser(user)
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
                            onCompletedRegistration(uid)
                        }
                    }
                }
        }

    }


    override fun emitSnackbar(snackbarEvent: SnackbarEvent) {
        viewModelScope.launch {
            _snackbarChannel.send(snackbarEvent)
        }
    }

    override fun inputIsValid(email: String, password: String, termsIsChecked: Boolean): Boolean {
        //checking if the email is empty
        if (email.isEmpty()) {
            _emailFieldState.update { it.copy(errorCode = R.string.error_email_not_provied, state = UIState.Error) }
            _btnRegister.update { UIState.Error }
            return false
        }
        // we only care if the password is empty to avoid sending requests that are obvious that are going to fail
        if (password.isEmpty()) {
            _passwordFieldState.update { it.copy(errorCode = R.string.error_password_not_provided, state = UIState.Error) }
            _btnRegister.update { UIState.Error }
            return false
        }

        val emailIsValid = emailValidator.check(email) == EmailValidator.Result.Valid

        Log.d("Test" , "emailState = $emailIsValid")

        if(!emailIsValid){
            _emailFieldState.update { it.copy(errorCode = R.string.error_invalid_email_format , state = UIState.Error) }
        }
        //We only care about the email because the backend will check if the password is correct (when sending the request to the server for auth )
        return emailIsValid
    }
    override fun onError(exception: Exception) {
        val snackbar = when (exception) {
            is AuthError.InvalidCredentials -> {
                //only necessary to display once the error message
                _emailFieldState.update { it.copy(errorCode = R.string.error_invalid_credentials, state = UIState.Error) }
                _passwordFieldState.update { it.copy(state = UIState.Error) }
                SnackbarEvent(
                    exception.message ?: "Unknown Error has occurred while logging in",
                    SnackbarEvent.EventType.Error
                )
            }

            is AuthError.InvalidEmailFormat -> {
                //Only change the email field because the password is not related to this error
                _emailFieldState.update { it.copy(errorCode = R.string.error_invalid_credentials, state = UIState.Error) }
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
            else->{
                    TODO()
            }
        }
        //Updating the state of the button
        _btnRegister.update { UIState.Error }
        //emitting the snackbar
        emitSnackbar(snackbar)
    }
}









