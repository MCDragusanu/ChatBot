package com.example.chatbot.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatbot.common.databases.user_database.User
import com.example.chatbot.common.ui.theme.ChatBotTheme
import com.example.chatbot.main.data.module.MainModule
import com.example.chatbot.main.data.question_metadata_database.cloud.CloudDataSource
import com.example.chatbot.main.data.question_metadata_database.entity.QuestionMetadata
import com.example.chatbot.main.domain.pre_defined_questions.predefinedTopics
import com.example.chatbot.main.domain.pre_defined_questions.topic1Questions
import com.example.chatbot.main.domain.pre_defined_questions.topic2Questions
import com.example.chatbot.main.domain.pre_defined_questions.topic3Questions
import com.example.chatbot.main.domain.pre_defined_questions.topic4Questions
import com.example.chatbot.main.domain.pre_defined_questions.topic5Questions
import com.example.chatbot.main.domain.pre_defined_questions.topic6Questions
import com.example.chatbot.main.domain.pre_defined_questions.topic7Questions
import com.example.chatbot.main.domain.pre_defined_questions.topic8Questions
import com.example.chatbot.main.domain.pre_defined_questions.topic9Questions
import com.example.chatbot.main.domain.use_cases.SyncronizeQuestions
import com.example.chatbot.main.domain.use_cases.SyncronizeTopics
import com.example.chatbot.main.presentation.home.HomeScreenImpl
import com.example.chatbot.main.presentation.home.HomeScreenViewModel
import com.example.chatbot.main.presentation.navigation.MainNavigation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
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

        lifecycleScope.launch {

            SyncronizeTopics.execute(mainModule, this)
            SyncronizeQuestions.execute(mainModule, this)
        }
       setContent {
           MainNavigation(
               homeScreen = HomeScreenImpl,
               homeScreenViewModel = viewModel<HomeScreenViewModel>().apply {
                   this.setModule(mainModule)
               })
       }
    }

    suspend fun postToCloud(module: MainModule) {
        predefinedTopics.onEach {
            module.cloudDataSource.addTopic(it, module.source)
        }
        module.cloudDataSource.addQuestions(
            topic1Questions + topic2Questions + topic3Questions + topic4Questions + topic5Questions + topic6Questions + topic8Questions + topic7Questions + topic9Questions,
            module.source
        )
    }


}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChatBotTheme {
        Greeting("Android")
    }
}