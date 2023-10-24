package com.example.chatbot.on_board


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.chatbot.R
import com.example.chatbot.on_board.data.module.OnBoardModule
import com.example.chatbot.on_board.presentation.login_screen.LoginScreenViewModelImpl

class OnBoardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create an OnBoardModule with test mode enabled.
        val onBoardModule = OnBoardModule.getModule(true)

        // Initialize the LoginScreenViewModel and set the OnBoardModule dependency.
        val loginScreenViewModel by viewModels<LoginScreenViewModelImpl>().apply {
            this.value.setModule(onBoardModule)
        }

        // Set the content view for the activity.
        setContent {
            // The Composable content for the OnBoardActivity can be defined here.
        }
    }
}