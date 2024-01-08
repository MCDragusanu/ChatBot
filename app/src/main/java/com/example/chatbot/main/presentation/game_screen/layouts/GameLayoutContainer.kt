package com.example.chatbot.main.presentation.game_screen.layouts

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatbot.common.ui.theme.Typography
import com.example.chatbot.common.ui.util.Destination
import com.example.chatbot.main.presentation.game_screen.controllers.QuizController
import com.example.chatbot.main.presentation.game_screen.state_manager.SessionStateManager

/**
 * Object representing the layout container for the game screen.
 * This object is used to compose the UI for the game screen, including navigation controls,
 * and the visual presentation of the current quiz.
 */
object GameLayoutContainer : Destination("LayoutContainer") {

    /**
     * Composable function to invoke the GameLayoutContainer and compose the UI for the game screen.
     *
     * @param stateManager The [SessionStateManager] responsible for managing the overall session state.
     */
    @Composable
    operator fun invoke(stateManager: SessionStateManager , onBackIsPressed: () -> Unit) {
        // Collect the current quiz controller from the state manager's currentController StateFlow.
        val currentQuizController by stateManager.currentController.collectAsState()
        val currentControllerIndex by stateManager.currentControllerIndex.collectAsState()
        // Compose the UI using the Scaffold and Column components.
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.Start
            ) {
                // Compose the TopAppBar with navigation controls.
                TopAppBar(onNextQuiz = stateManager::onNextQuiz, onBackIsPressed =onBackIsPressed ,onPrevQuiz = stateManager::onPrevQuiz)

                // Compose content based on the visibility of the current quiz controller.
                AnimatedVisibility(visible = currentQuizController == null) {
                    Text(text = "No Controller found")
                }

                AnimatedVisibility(visible = currentQuizController != null) {
                    // Compose the content based on the current quiz controller.
                    currentQuizController?.let {
                        it.getLayout().invoke(
                            Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),currentControllerIndex ,controller = it, onCompletion = stateManager::onNextQuiz)
                    }
                }
            }
        }
    }

    /**
     * Composable function to render the TopAppBar with navigation controls.
     *
     * @param onNextQuiz Callback function to be executed when moving to the next quiz.
     * @param onPrevQuiz Callback function to be executed when moving to the previous quiz.
     */
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopAppBar(onNextQuiz: () -> Unit, onPrevQuiz: () -> Unit , onBackIsPressed:()->Unit) {
        Column(modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp , Alignment.Top) , horizontalAlignment = Alignment.Start) {

            Icon(imageVector = Icons.Filled.ArrowBackIosNew, contentDescription = null , modifier = Modifier.clickable { onBackIsPressed() })
            Text(text = "Quiz Game" , style = Typography.headlineSmall)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = onPrevQuiz,colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer), shape = RoundedCornerShape(4.dp),modifier = Modifier.weight(1f, true)) {
                   Icon(imageVector = Icons.Filled.KeyboardArrowLeft , contentDescription = null )
                    Text(text = "Previous")
                }
                Button(onClick = onNextQuiz, shape = RoundedCornerShape(4.dp),colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),modifier = Modifier.weight(1f, true)) {
                    Text(text = "Next")
                    Icon(imageVector = Icons.Filled.KeyboardArrowRight , contentDescription = null )
                }
            }
        }
    }


}
