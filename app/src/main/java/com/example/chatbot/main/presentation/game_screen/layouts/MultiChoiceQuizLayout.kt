package com.example.chatbot.main.presentation.game_screen.layouts

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.chatbot.common.ui.theme.Typography
import com.example.chatbot.common.ui.util.Destination
import com.example.chatbot.main.presentation.game_screen.controllers.QuizController
import com.example.chatbot.main.presentation.game_screen.model.QuizEvent
import com.example.chatbot.main.presentation.game_screen.model.QuizState
import kotlinx.coroutines.flow.map

/**
 * Object representing the layout for the MultiChoiceQuizScreen destination.
 * Implements the [QuizLayout] interface to define the visual presentation for multi-choice quizzes.
 * This object is used in conjunction with a [QuizController] to compose the UI and handle user interactions.
 */
object MultiChoiceQuizLayout : Destination("MultiChoiceQuizScreen"), QuizLayout {

    /**
     * Composable function to invoke the MultiChoiceQuizLayout and compose the UI based on the quiz state.
     *
     * @param controller The [QuizController] associated with the multi-choice quiz.
     * @param onCompletion Callback function to be executed when the quiz is completed.
     */
    @Composable
    override fun invoke(
        modifier: Modifier,
        questionIndex: Int,
        controller: QuizController,
        onCompletion: () -> Unit
    ) {
        // Collect the current state of the multi-choice quiz from the controller's state flow.
        val _state by controller.presentState().collectAsState()

        // Safely cast the state to the specific type for multi-choice quizzes.
        val currentState = _state as QuizState.MultiChoiceQuizState?
        val screenState by controller.screenState.collectAsState()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ) {
            currentState?.let { currentState ->
                Crossfade(targetState = screenState, label = "") { state ->
                    when (state) {

                        QuizState.PossibleState.Loading -> {
                            Column(
                                modifier = Modifier.padding(it),
                                verticalArrangement = Arrangement.spacedBy(
                                    16.dp,
                                    Alignment.CenterVertically
                                )
                            ) {
                                LinearProgressIndicator()
                                Text(
                                    text = "Setting up the Quiz for you",
                                    style = Typography.headlineSmall
                                )
                            }
                        }

                        QuizState.PossibleState.Default -> {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    text = currentState.topicName, style = Typography.bodySmall,
                                    maxLines = 5,
                                    color = MaterialTheme.colorScheme.onBackground.copy(0.5f),
                                    overflow = TextOverflow.Ellipsis,
                                )
                                Text(
                                    text = "${questionIndex + 1}.) ${currentState.questionContent}",
                                    style = Typography.labelLarge
                                )
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(),
                                    horizontalAlignment = Alignment.Start,
                                    verticalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    currentState.allAnswers.onEachIndexed { index, content ->

                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .clickable {
                                                    controller.onEvent(
                                                        QuizEvent.NewAnswerPicked(
                                                            index
                                                        )
                                                    )
                                                }
                                                .wrapContentHeight(),
                                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {

                                            Icon(
                                                imageVector = Icons.Filled.Adjust,
                                                contentDescription = null,
                                                tint = animateColorAsState(
                                                    targetValue = if (index == currentState.currentPickedAnswer) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onBackground.copy(
                                                        0.5f
                                                    ),
                                                    label = ""
                                                ).value
                                            )

                                            Text(
                                                text = content,
                                                style = Typography.labelLarge,
                                               color = animateColorAsState(
                                                    targetValue = if (index == currentState.currentPickedAnswer) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onBackground.copy(
                                                        0.5f
                                                    ),
                                                    label = ""
                                                ).value,
                                                maxLines = 2
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.fillMaxHeight(0.33f))
                                Button(onClick = { controller.onEvent(QuizEvent.QuizSubmission()) }) {
                                    Text(text = "Submit Answer!")
                                }
                            }
                        }

                        QuizState.PossibleState.FailedToLoad -> {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.spacedBy(
                                    12.dp,
                                    Alignment.CenterVertically
                                ),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "It Seems the conversation was unable to load properly :(. Would You like to try again")
                                Button(
                                    onClick = { controller.loadResources() },
                                    colors = ButtonDefaults.buttonColors(
                                        MaterialTheme.colorScheme.errorContainer,
                                        MaterialTheme.colorScheme.onErrorContainer
                                    )
                                ) {
                                    Text(text = "Retry")
                                }
                            }
                        }

                        QuizState.PossibleState.Completed -> {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight(),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = currentState.topicName, style = Typography.bodySmall,
                                    maxLines = 5,
                                    color = MaterialTheme.colorScheme.onBackground.copy(0.5f),
                                    overflow = TextOverflow.Ellipsis,
                                )
                                Text(
                                    text = "${questionIndex + 1}.) ${currentState.questionContent}",
                                    style = Typography.labelLarge
                                )
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(),
                                    horizontalAlignment = Alignment.Start,
                                    verticalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    currentState.allAnswers.onEachIndexed { index, content ->

                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .clickable {
                                                    controller.onEvent(QuizEvent.NewAnswerPicked(0))
                                                }
                                                .wrapContentHeight(),
                                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(
                                                imageVector = if (index == currentState.correctAnswerIndex) Icons.Filled.CheckCircle else Icons.Filled.Block,
                                                contentDescription = null,
                                                tint = if (index == currentState.correctAnswerIndex) Color.Green else Color.Red
                                            )
                                            Text(
                                                text = content,
                                                style = Typography.labelMedium,
                                                color = if (index == currentState.correctAnswerIndex) Color.Green.copy(
                                                    alpha = 0.5f
                                                ) else Color.Red.copy(alpha = 0.5f)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}