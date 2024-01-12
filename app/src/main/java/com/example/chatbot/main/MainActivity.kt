package com.example.chatbot.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatbot.common.databases.user_database.User
import com.example.chatbot.common.ui.theme.ChatBotTheme

import com.example.chatbot.main.data.module.MainModule
import com.example.chatbot.main.data.database_questions.cloud.CloudDataSource
import com.example.chatbot.main.data.database_questions.entity.Question
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
        val mainModule = MainModule.getInstance(
            true,
            this.application,
            dataSource = CloudDataSource.DataSource.ProjectDatabase,
            currentUser = User()
        )
        addQuestionToDatabase(mainModule)
        lifecycleScope.launch {
            SyncronizeTopics.execute(mainModule, this)
            SyncronizeQuestions.execute(mainModule, this)
        }

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

    fun addQuestionToDatabase(module: MainModule) {
        var questionUid: Long = 9999
        val questions = listOf<Question>(
            Question(
                uid = ++questionUid,
                questionContent = "What are the main types of text\n based digital content",
                incorrectAnswers = buildString {

                    listOf("","",""
                      /*aici puneti raspunsurile incorecte*/
                    ).onEach {
                        /*aici nu modificati*/
                        append(it)
                        append("/")
                    }

                },
                correctAnswer = "articles, blog posts, ebooks, and whitepapers.",
                topicUid = 3,
                questionType = Question.MULTICHOICE
            ),
            Question(
                uid = ++questionUid,
                questionContent = "How can user generated content be leveraged to benefit a brand's digital marketing strategy",
                incorrectAnswers = buildString {
                    listOf("","",""
                       ).onEach {
                        append(it)
                        append("/")
                    }
                },
                topicUid = 3,
                correctAnswer = "User generated content provides genuine feedback and testimonials from real customers, which can enhance the brand's credibility and build trust with potential customers",
            )

        )
        lifecycleScope.launch {
            questions.onEach {
                Log.d("Test", "topicUId = ${it.topicUid} , questionUid = ${it.uid} , incorrectAnswer = ${it.incorrectAnswers}  ,correctAnswer = ${it.correctAnswer}")
            }
            module.cloudDataSource.addQuestions(questions, module.source)
        }

    }

}



