package com.example.chatbot.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.chatbot.common.ui.theme.ChatBotTheme
import com.example.chatbot.main.data.module.MainModule
import com.example.chatbot.main.data.question_metadata_database.cloud.CloudDataSource
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
import com.example.chatbot.main.presentation.composables.TestPreview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainModule = MainModule.getInstance(
            true,
            this.application,
            dataSource = CloudDataSource.DataSource.ProjectDatabase
        )
        buildProjectDatabase(mainModule)
        setContent {
           // TestPreview()
        }
    }

    fun buildProjectDatabase(module: MainModule) {
        CoroutineScope(Dispatchers.IO).launch {
           /* predefinedTopics.onEach {
                module.cloudDataSource.addTopic(it, module.topicsSource)
            }*/
            module.cloudDataSource.addQuestions(topic2Questions + topic3Questions + topic5Questions + topic6Questions + topic7Questions + topic8Questions + topic9Questions , module.topicsSource)
        }
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