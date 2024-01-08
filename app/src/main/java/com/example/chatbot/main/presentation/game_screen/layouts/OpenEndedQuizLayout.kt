package com.example.chatbot.main.presentation.game_screen.layouts

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.chatbot.common.ui.theme.Typography
import com.example.chatbot.common.ui.util.Destination
import com.example.chatbot.main.data.database_messages.model.Message
import com.example.chatbot.main.data.database_questions.entity.Question
import com.example.chatbot.main.presentation.game_screen.controllers.QuizController
import com.example.chatbot.main.presentation.game_screen.model.QuizEvent
import com.example.chatbot.main.presentation.game_screen.model.QuizState
import javax.xml.validation.TypeInfoProvider

/**
 * Object representing the layout for the OpenEndedQuizScreen destination.
 * Implements the [QuizLayout] interface to define the visual presentation for open-ended question quizzes.
 * This object is used in conjunction with a [QuizController] to compose the UI and handle user interactions.
 */
object OpenEndedQuizLayout : Destination("OpenEndedQuizScreen"), QuizLayout {

    /**
     * Composable function to invoke the OpenEndedQuizLayout and compose the UI based on the quiz state.
     *
     * @param controller The [QuizController] associated with the open-ended question quiz.
     * @param onCompletion Callback function to be executed when the quiz is completed.
     */
    @Composable
    override fun invoke(
        modifier: Modifier,
        questionIndex: Int,
        controller: QuizController,
        onCompletion: () -> Unit
    ) {
        // Collect the current state of the open-ended quiz from the controller's state flow.
        val _state by controller.presentState().collectAsState()

        // Safely cast the state to the specific type for open-ended quizzes.
        val currentState = _state as QuizState.OpenEndedQuizState?
        val screenState by controller.screenState.collectAsState()
        Scaffold(modifier = modifier, containerColor = Color.Transparent, floatingActionButton = {



        }) {

            Crossfade(
                targetState = screenState, modifier = Modifier
                    .padding(it)
                    .padding(12.dp),
                label = ""
            ) {

                when (it) {
                    QuizState.PossibleState.Default, QuizState.PossibleState.Completed -> {
                       currentState?.let {
                           Conversation(
                               currentState = currentState,
                               questionIndex = questionIndex,
                               screenState = screenState,
                               onSendMessage = { controller.onEvent(QuizEvent.NewUserMessage(it)) }
                           )
                       }
                    }
                    QuizState.PossibleState.FailedToLoad-> {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(
                                12.dp,
                                Alignment.CenterVertically
                            ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "It Seems the conversation was unable to load properly :(. Would You like to try again")
                            Button(onClick = { controller.loadResources() },
                                colors = ButtonDefaults.buttonColors(
                                    MaterialTheme.colorScheme.errorContainer,
                                    MaterialTheme.colorScheme.onErrorContainer
                                )) {
                                Text(text = "Retry")
                            }
                        }
                    }
                    QuizState.PossibleState.Loading -> {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(
                                12.dp,
                                Alignment.CenterVertically
                            ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            LinearProgressIndicator()
                            Text(
                                text = "Setting Up Conversation...",
                                style = Typography.labelMedium
                            )
                            Spacer(modifier = Modifier.fillMaxHeight(0.25f))
                            Row(
                                modifier = Modifier.wrapContentSize(),
                                horizontalArrangement = Arrangement.spacedBy(
                                    4.dp,
                                    Alignment.CenterHorizontally
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Powered By",
                                    style = Typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onBackground.copy(0.25f)
                                )
                                Text(
                                    text = "ChatGPT",
                                    style = Typography.headlineSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Conversation( currentState:QuizState.OpenEndedQuizState ,screenState:QuizState.PossibleState, onSendMessage:(String)->Unit,questionIndex:Int){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            verticalArrangement = Arrangement.Top
        ) {
            QuestionHeadline(
                modifier = Modifier.weight(1f, true),
                question = currentState?.question ?: Question(),
                index = questionIndex
            )
            Column(
                modifier = Modifier
                    .weight(4f, true)
                    .verticalScroll(rememberScrollState(), true),
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start
            ) {
                currentState?.let {
                    it.conversation.onEach {
                        if (!it.isSystemMessage()) {
                            MessageCard(message = it)
                        }
                    }
                }
            }
            AnimatedVisibility(visible = screenState == QuizState.PossibleState.Completed) {
                Card(
                    modifier = Modifier
                        .wrapContentHeight(Alignment.CenterVertically)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .fillMaxWidth(1f)
                        .wrapContentHeight()
                        ,
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Green.copy(0.25f),
                        contentColor = Color.Green
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(
                            12.dp,
                            Alignment.CenterHorizontally
                        )
                    ) {
                        Text(text = "Question Answered")
                        Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = null)
                    }
                }
            }
            AnimatedVisibility(visible = screenState == QuizState.PossibleState.Default) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(1.0f)
                        .wrapContentHeight(),
                    onClick = { onSendMessage(it) })
            }
        }
    }
    @Composable
    fun MessageCard(message: Message) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (message.isSentByUser()) Arrangement.Start else Arrangement.End
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .wrapContentHeight()
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(8.dp),
                ) {
                    Text(text = message.content)
                }
            }
        }
    }

    @Composable
    fun QuestionHeadline(modifier: Modifier, question: Question, index: Int) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .then(modifier),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "${index + 1}. ",
                style = Typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
            Text(text = question.questionContent, style = Typography.labelLarge)
        }
    }

    @Composable
    fun TextField(modifier: Modifier, onClick: (String) -> Unit) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .then(modifier),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
        ) {
            var currentText by rememberSaveable {
                mutableStateOf("")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 12.dp, horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .weight(3.5f, true)
                        .height(50.dp),
                    value = currentText,
                    colors = TextFieldDefaults.colors(
                        disabledContainerColor = Color.Transparent,
                        errorContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    ),
                    onValueChange = { currentText = it })

                Icon(
                    imageVector = Icons.Filled.Send,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .weight(0.5f, true)
                        .clickable { if (currentText.isNotBlank()) onClick(currentText) })
            }
        }
    }
}

