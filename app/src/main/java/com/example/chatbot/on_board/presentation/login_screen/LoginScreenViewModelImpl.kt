package com.example.chatbot.on_board.presentation.login_screen

import com.example.chatbot.common.SnackbarEvent
import kotlinx.coroutines.flow.update

class LoginScreenViewModelImpl:LoginScreenViewModel() {
    override fun onEmailChanged(newEmail: String) {

       this._emailState.update { it.copy(content = newEmail) }
    }

    override fun onPasswordChanged(newPassword: String) {
       this._passwordState.update { it.copy(content = newPassword) }
    }

    override fun sendPasswordResetEmail(email: String) {
        TODO("Not yet implemented")
    }

    override fun emitSnackbar(snackbarEvent: SnackbarEvent) {
        TODO("Not yet implemented")
    }

    override fun inputIsValid(email: String, password: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun onLoginIsPressed(onCompletedLogin: (String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun onError(exception: Exception) {
        TODO("Not yet implemented")
    }
}