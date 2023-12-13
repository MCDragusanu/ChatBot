package com.example.chatbot.main.presentation.home

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.example.chatbot.common.databases.question_database.TopicMetadata

interface HomeScreen {


    @Composable
    fun Main(homeScreenViewModel: ViewModel, onStartNewSession:(Long)->Unit)

    @Composable
    fun Headline()

    @Composable
    fun StatsCard()

    @Composable
    fun RecentSessions()

    @Composable
    fun NewSessionDialog(onDismiss:()->Unit , onSubmit:(List<TopicMetadata>, difficultyLevel:Int, numberOfQuestions:Int) ->Unit)
}