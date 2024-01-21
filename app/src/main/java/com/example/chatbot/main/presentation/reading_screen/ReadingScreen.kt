package com.example.chatbot.main.presentation.reading_screen

import androidx.compose.runtime.Composable

interface ReadingScreen {


    @Composable
    fun Main(viewModel: ReadingScreenViewModel ,
             onStartSelfAssessment:(sessionUid:Long)->Unit ,
             onStartOfficialAssessment:(sessionUid:Long)->Unit)
}