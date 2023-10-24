package com.example.chatbot.on_board.presentation.login_screen

import com.example.chatbot.common.SnackbarEvent

class LoginScreenViewModelImpl:LoginScreenViewModel() {
    override fun onEmailChanged(newEmail: String) {
        TODO("Not yet implemented")
    }

    override fun onPasswordChanged(newPassword: String) {
        TODO("Not yet implemented")
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
}