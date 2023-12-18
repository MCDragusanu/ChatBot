package com.example.chatbot.main.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.chatbot.common.databases.user_database.User
import com.example.chatbot.common.ui.theme.Typography
import com.example.chatbot.main.data.question_metadata_database.entity.TopicMetadata
import com.example.chatbot.main.presentation.composables.ProgressVisualizer
import com.example.chatbot.on_board.presentation.on_board_screen.OnBoardScreenImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object HomeScreenImpl : HomeScreen() {
    @Composable
    override fun Main(homeScreenViewModel: HomeScreenViewModel, onStartNewSession: (Long) -> Unit) {
        val topics by homeScreenViewModel.topics.collectAsState()
        val topicsRowState = rememberLazyListState()
        val currentTopic = MutableStateFlow(topicsRowState.firstVisibleItemIndex)
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(48.dp)
            ) {

                item {
                    Headline(
                        currentUser = homeScreenViewModel.getCurrentUser(),
                        onAccountClicked = {},
                        onSettingsClicked = {})
                }

                item {
                    CourseProgression(
                        topicsRowState = topicsRowState,
                        topics = topics,
                        currentTopic = currentTopic,
                        status = homeScreenViewModel::getQuestionsMetadataForTopic
                    )
                }

            }
        }
        LaunchedEffect(key1 = remember { derivedStateOf { topicsRowState.firstVisibleItemIndex } }) {
            currentTopic.emit(topicsRowState.firstVisibleItemIndex)
        }
    }

    @Composable
    override fun Headline(currentUser: User , onSettingsClicked:()->Unit , onAccountClicked:()->Unit) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .wrapContentSize()
            ) {
                Text(text = "Welcome Back" , color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.25f))
                Text(text = currentUser.firstName + " " + currentUser.lastName , style = Typography.headlineSmall)
            }
            Row {
                IconButton(onClick =  onSettingsClicked) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = null)
                }
                IconButton(onClick = onAccountClicked) {
                    Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = null)
                }
            }
        }
    }

    @Composable
     fun CourseProgression(topicsRowState:LazyListState , topics:List<TopicMetadata >, currentTopic:StateFlow<Int>,status:(Int)-> Flow<List<Int>>) {

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Your Courses", style = Typography.headlineSmall)
            Text(
                text = "See your progress on each course and see your strength and weaknesses",
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.25f)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                LazyRow(
                    state = topicsRowState,
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(topics, key = { it.uid }) {
                        val statusList by status(it.uid).collectAsState(initial = emptyList())
                        Log.d("Test", "Retrieved ${statusList.size} items")
                        StatsCard(
                            modifier = Modifier
                                .fillParentMaxWidth(0.7f)
                                .height(200.dp), topicMetadata = it, questionsStatus = statusList
                        )
                    }
                }
                OnBoardScreenImpl.ItemSlider(
                    modifier = Modifier.width(200.dp),
                    currentItem = currentTopic,
                    numberOfItems = topics.size-1,
                    defaultItemContent = {
                        Surface(
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier.size(10.dp)
                        ) {

                        }
                    }
                )
            }
        }
    }

    @Composable
    override fun StatsCard(modifier: Modifier ,topicMetadata: TopicMetadata ,  questionsStatus : List<Int>) {
        Card(modifier = modifier) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(12.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = topicMetadata.label, style = Typography.labelLarge)
                    if (topicMetadata.imageUid != -1) {
                        Icon(
                            painter = painterResource(id = topicMetadata.uid),
                            contentDescription = null,
                            modifier = modifier.size(36.dp)
                        )
                    }
                }
                Text(text = "Progress")
                ProgressVisualizer(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .wrapContentHeight(),
                    questionsStatus,
                    questionsPerRow = 7
                )
            }
        }
    }

    @Composable
    override fun RecentSessions() {
        TODO("Not yet implemented")
    }

    @Composable
    override fun NewSessionDialog(
        onDismiss: () -> Unit,
        onSubmit: (List<TopicMetadata>, difficultyLevel: Int, numberOfQuestions: Int) -> Unit
    ) {
        TODO("Not yet implemented")
    }
}