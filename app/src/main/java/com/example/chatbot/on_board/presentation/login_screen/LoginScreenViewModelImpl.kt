package com.example.chatbot.on_board.presentation.login_screen

import androidx.lifecycle.viewModelScope
import com.example.chatbot.R
import com.example.chatbot.account_manager.AccountErrors
import com.example.chatbot.common.SnackbarEvent
import com.example.chatbot.common.UIState
import com.example.chatbot.on_board.domain.EmailValidator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginScreenViewModelImpl:LoginScreenViewModel() {
    override fun onEmailChanged(newEmail: String) {


    }

    override fun onPasswordChanged(newPassword: String) {

    }

    override fun sendPasswordResetEmail(email: String , onCompleted:()->Unit) {

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