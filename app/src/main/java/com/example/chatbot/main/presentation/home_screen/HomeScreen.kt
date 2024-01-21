package com.example.chatbot.main.presentation.home_screen

import androidx.compose.runtime.Composable

interface HomeScreen {

    @Composable
    fun Main(
        viewModel: HomeViewModel,
        navigateToReadingScreen: (topicUid: Int) -> Unit,
        onBackIsPressed: () -> Unit
    )
}