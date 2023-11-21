package com.example.chatbot.on_board.presentation.registration_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chatbot.common.ui.util.TextFieldState
import kotlinx.coroutines.flow.StateFlow

object RegistrationScreenImpl:RegistrationScreen() {
    @Composable
    override fun Main(viewModel: RegistrationScreenViewModel, onCompletedRegistration: (String) -> Unit) {
        TODO("Not yet implemented")
    }

    @Composable
    override fun EmailTextField(
        modifier: Modifier,
        textFieldState: StateFlow<TextFieldState>,
        onValueChanged: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    @Composable
    override fun PasswordTextField(
        modifier: Modifier,
        textFieldState: StateFlow<TextFieldState>,
        onValueChanged: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    @Composable
    override fun TermsOfUseCheckBox(modifier: Modifier, state: StateFlow<Boolean>, onStateChanged: (Boolean) -> Unit) {
        TODO("Not yet implemented")
    }

    @Composable
    override fun TermsOfUseDialog(onDismiss: () -> Unit, onRejected: () -> Unit, onAccepted: () -> Unit) {
        TODO("Not yet implemented")
    }


}