package com.example.chatbot.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatbot.common.databases.user_database.User
import com.example.chatbot.common.databases.user_database.UserRepositoryImpl
import com.example.chatbot.common.ui.theme.ChatBotTheme

import com.example.chatbot.main.data.module.MainModule
import com.example.chatbot.main.data.database_questions.cloud.CloudDataSource
import com.example.chatbot.main.data.database_questions.entity.Question
import com.example.chatbot.main.data.database_questions.entity.TopicMetadata
import com.example.chatbot.main.domain.use_cases.SyncronizeQuestions
import com.example.chatbot.main.domain.use_cases.SyncronizeTopics
import com.example.chatbot.main.presentation.game_screen.state_manager.SessionStateManager
import com.example.chatbot.main.presentation.home.HomeScreenImpl
import com.example.chatbot.main.presentation.home.HomeScreenViewModel
import com.example.chatbot.main.presentation.navigation.MainNavigation
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userUid = intent.getStringExtra("USER_UID")
        val mainModule = MainModule.getInstance(
            true,
            this.application,
            dataSource = CloudDataSource.DataSource.ProjectDatabase,
            currentUserUid = userUid
        )



        setContent {
            ChatBotTheme() {
                MainNavigation(
                    homeScreen = HomeScreenImpl,
                    sessionStateManager = viewModel<SessionStateManager>().apply {
                        this.setModule(
                            mainModule
                        )
                    },
                    homeScreenViewModel = viewModel<HomeScreenViewModel>().apply {
                        this.setModule(mainModule)
                    })
            }
        }
    }

    /*suspend fun postToCloud(module: MainModule) {
        predefinedTopics.onEach {
            module.cloudDataSource.addTopic(it, module.source)
        }
        module.cloudDataSource.addQuestions(
            topic1Questions + topic2Questions + topic3Questions + topic4Questions + topic5Questions + topic6Questions + topic8Questions + topic7Questions + topic9Questions,
            module.source
        )
    }*/


}



