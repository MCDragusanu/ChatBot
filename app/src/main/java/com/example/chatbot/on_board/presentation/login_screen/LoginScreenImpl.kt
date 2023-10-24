package com.example.chatbot.on_board.presentation.login_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chatbot.common.TextFieldState
import com.example.chatbot.common.UIState
import kotlinx.coroutines.flow.StateFlow

object LoginScreenImpl:LoginScreen {
    @Composable
    override fun Main(viewModel: LoginScreenViewModel, onLoginCompleted: (String) -> Unit, onRegister: () -> Unit) {
        TODO("Not yet implemented")
    }
    @Composable
    override fun EmailButton(modifier: Modifier, state: StateFlow<TextFieldState>, onValueChanged: (String) -> Unit) {
        TODO("Not yet implemented")
    }
    @Composable
    override fun PasswordButton(
        modifier: Modifier,
        state: StateFlow<TextFieldState>,
        onValueChanged: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }
    @Composable
    override fun LoginButton(modifier: Modifier, state: StateFlow<UIState>, onClick: () -> Unit) {
        TODO("Not yet implemented")
    }
}