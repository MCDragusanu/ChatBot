package com.example.chatbot.main.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.example.chatbot.common.databases.user_database.User
import com.example.chatbot.main.data.question_metadata_database.entity.TopicMetadata
import com.google.android.datatransport.runtime.Destination

abstract class HomeScreen : com.example.chatbot.common.ui.util.Destination("HomeScreen") {


    @Composable
    abstract fun Main(homeScreenViewModel: HomeScreenViewModel, onStartNewSession: (Long) -> Unit)

    @Composable
    abstract fun Headline(currentUser: User, onSettingsClicked:()->Unit , onAccountClicked:()->Unit)

    @Composable
    abstract fun StatsCard(modifier: Modifier ,topicMetadata: TopicMetadata ,  questionsStatus : List<Int>)

    @Composable
    abstract fun RecentSessions()

    @Composable
    abstract fun NewSessionDialog(
        onDismiss: () -> Unit,
        onSubmit: (List<TopicMetadata>, difficultyLevel: Int, numberOfQuestions: Int) -> Unit
    )
}