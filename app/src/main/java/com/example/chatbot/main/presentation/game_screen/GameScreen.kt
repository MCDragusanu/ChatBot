package com.example.chatbot.main.presentation.game_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.chatbot.common.ui.theme.Typography
import com.example.chatbot.common.ui.util.Destination
import com.example.chatbot.main.data.database_messages.model.ThreadMetadata
import com.example.chatbot.main.data.database_questions.entity.Question
import com.example.chatbot.main.domain.instruction_factory.GPTResponse

 class  GameScreen : Destination("GameScreen") {

    @Composable
    fun Main(controller: GameController) {
        val currentThread by controller.currentThread.collectAsState(null)
        val threads by controller.threads.collectAsState()
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(12.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                threads.onEachIndexed { index  ,thread->
                    ThreadCard(modifier = Modifier.fillMaxWidth().wrapContentHeight() ,thread , index , controller::getQuestionString)
                }
            }
        }
    }

    @Composable
    fun ThreadCard(modifier: Modifier,threadMetadata: ThreadMetadata , index:Int,getQuestion:(threadMetadata: ThreadMetadata) -> String) {
        Card(modifier = modifier) { ThreadHeadline(threadMetadata, index, getQuestion) }
    }
    @Composable
    fun ThreadHeadline(threadMetadata: ThreadMetadata , index: Int , getQuestion:(threadMetadata: ThreadMetadata) -> String){
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight() , verticalArrangement = Arrangement.SpaceEvenly , horizontalAlignment = Alignment.Start) {
            Row{
                Text(
                    text = "${index + 1}",
                    style = Typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(text = getQuestion(threadMetadata), style = Typography.labelMedium)
            }
        }
    }
}