package com.example.chatbot.on_board.presentation.registration_screen

import com.example.chatbot.common.SnackbarEvent

class RegistrationScreenViewModelImpl:RegistrationScreenViewModel() {
    override fun onEmailChanged(newEmail: String) {
        TODO("Not yet implemented")
    }

    override fun onPasswordChanged(newPassword: String) {
        TODO("Not yet implemented")
    }

    override fun onTermsChanged(boolean: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onRegister(onCompletedRegistration: (String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun emitSnackbar(snackbarEvent: SnackbarEvent) {
        TODO("Not yet implemented")
    }

    override fun inputIsValid(email: String, password: String, termsIsChecked: Boolean): Boolean {
        TODO("Not yet implemented")
    }
    override fun onError(exception: Exception) {
        TODO("Not yet implemented")
    }
}