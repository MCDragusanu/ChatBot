package com.example.chatbot.main.presentation.home

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FullscreenExit
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.chatbot.common.databases.user_database.User
import com.example.chatbot.common.ui.theme.Typography
import com.example.chatbot.main.data.database_messages.model.SessionMetadata
import com.example.chatbot.main.data.database_questions.entity.TopicMetadata
import com.example.chatbot.main.presentation.composables.ProgressVisualizer
import com.example.chatbot.on_board.presentation.on_board_screen.OnBoardScreenImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.SimpleDateFormat
import java.util.Random
import kotlin.streams.toList

object HomeScreenImpl : HomeScreen() {
    @Composable
    // The Main function represents the main content of the home screen.
    override fun Main(homeScreenViewModel: HomeScreenViewModel, onStartNewSession: (Long) -> Unit) {
        // Collect the state of topics from the ViewModel as a Composable State.
        val topics by homeScreenViewModel.topics.collectAsState()

        // Create a LazyListState to manage the state of the LazyColumn.
        val topicsRowState = rememberLazyListState()

        var showDialog by remember { mutableStateOf(false) }
        // Create a MutableStateFlow to track the current visible topic.
        val currentTopic = MutableStateFlow(topicsRowState.firstVisibleItemIndex)

        // Collect the state of recent sessions from the ViewModel as a Composable State.
        val recentSessions by homeScreenViewModel.recentSessions.collectAsState()

        // Scaffold is a Material Design container for the screen layout.
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            floatingActionButton = {
                Button(onClick = { showDialog = true }) {
                    Text("Create new Quiz")
                }
            },
            containerColor = MaterialTheme.colorScheme.background
        ) {
            // LazyColumn is a vertically scrolling list of composable items.
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)  // Apply padding to the LazyColumn
                    .padding(16.dp),  // Additional padding
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(72.dp)  // Spacing between items
            ) {
                // Item 1: Headline section displaying user information and action buttons.
                item {
                    Headline(
                        currentUser = homeScreenViewModel.getCurrentUser(),
                        onAccountClicked = {},  // Placeholder click handler for account action
                        onSettingsClicked = {}  // Placeholder click handler for settings action
                    )
                }

                // Item 2: CourseProgression section displaying the user's course progress.
                item {
                    CourseProgression(
                        topicsRowState = topicsRowState,
                        topics = topics,
                        currentTopic = currentTopic,
                        status = homeScreenViewModel::getQuestionsMetadataForTopic
                    )
                }

                // Item 3: RecentSessions section displaying the user's recent quiz sessions.
                item {
                    RecentSessions(
                        sessions = recentSessions,
                        getTopicsLabels = homeScreenViewModel::getTopicsLabel,
                        onClick = {}  // Placeholder click handler for session item
                    )
                }



            }
        }
        if (showDialog) {
            NewSessionDialog(
                onDismiss = { showDialog = false },
                topics = topics,
                onTopicSelected = homeScreenViewModel::onTopicSelected,
                selectedTopics = homeScreenViewModel.selectedTopics,
                onQuestionCountChanged = homeScreenViewModel::onQuestionCountChanged,
                selectedQuestionCount = homeScreenViewModel.questionCount,
                onSubmit = {

                })
        }

        // LaunchedEffect is used to observe changes in the visible item index and update the currentTopic.
        LaunchedEffect(key1 = remember { derivedStateOf { topicsRowState.firstVisibleItemIndex } }) {
            currentTopic.emit(topicsRowState.firstVisibleItemIndex)
        }
    }

    // Composable function to display the headline section with user information and action buttons.
    @Composable
    override fun Headline(
        currentUser: User,
        onSettingsClicked: () -> Unit,
        onAccountClicked: () -> Unit
    ) {
        // Row to arrange the contents horizontally with space between them.
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Column to arrange the texts vertically.
            Column(
                modifier = Modifier
                    .wrapContentSize()
            ) {
                // Text displaying a welcome message.
                Text(
                    text = "Welcome Back",
                    color = MaterialTheme.colorScheme.onBackground.copy(0.25f),
                    style = Typography.bodySmall
                )
                // Text displaying the user's full name.
                Text(
                    text = currentUser.firstName + " " + currentUser.lastName,
                    style = Typography.headlineSmall
                )
            }
            // Row to arrange the icon buttons horizontally.
            Row {
                // IconButton for settings with a click handler.
                IconButton(onClick = onSettingsClicked) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                // IconButton for account with a click handler.
                IconButton(onClick = onAccountClicked) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }


    // Composable function to display the course progression section.
    @Composable
    fun CourseProgression(
        topicsRowState: LazyListState,
        topics: List<TopicMetadata>,
        currentTopic: StateFlow<Int>,
        status: (Int) -> Flow<List<Int>>
    ) {
        // Column to arrange the contents vertically.
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Text displaying the section title.
            Text(text = "Your Courses", style = Typography.headlineSmall)

            // Text providing additional information about the section.
            Text(
                text = "See your progress on each course and see your strength and weaknesses",
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.25f),
                style = Typography.bodySmall
            )

            // Nested Column for further organization.
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // LazyRow is a horizontally scrolling list.
                LazyRow(
                    state = topicsRowState,
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // Iterate over the list of topics and create StatsCard for each.
                    items(topics, key = { it.uid }) {
                        // Collect the status of the current topic.
                        val statusList by status(it.uid).collectAsState(initial = emptyList())
                        // Log the number of items retrieved (for testing purposes).
                        Log.d("Test", "Retrieved ${statusList.size} items")
                        // Display a StatsCard for the current topic.
                        StatsCard(
                            modifier = Modifier
                                .fillParentMaxWidth(0.7f)
                                .height(175.dp),
                            topicMetadata = it,
                            questionsStatus = statusList
                        )
                    }
                }

                // ItemSlider for navigating through topics.
                OnBoardScreenImpl.ItemSlider(
                    modifier = Modifier.width(200.dp),
                    currentItem = currentTopic,
                    numberOfItems = topics.size - 1,
                    defaultItemContent = {
                        // Placeholder content for default item in the slider.
                        Surface(
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier.size(10.dp)
                        ) {
                            // Empty surface representing a default item.
                        }
                    }
                )
            }
        }
    }

    // Composable function to display a statistics card for a specific topic.
    @Composable
    override fun StatsCard(
        modifier: Modifier,
        topicMetadata: TopicMetadata,
        questionsStatus: List<Int>
    ) {
        // Card composable with a custom modifier and color scheme.
        Card(
            modifier = modifier,
            colors = CardDefaults.cardColors(
                MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        ) {
            // Column to arrange the contents vertically with padding.
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Row displaying the topic label and optional topic image.
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Text displaying the label of the topic.
                    Text(text = topicMetadata.label, style = Typography.labelLarge)
                    // Display an optional topic image if available.
                    if (topicMetadata.imageUid != -1) {
                        Icon(
                            painter = painterResource(id = topicMetadata.uid),
                            contentDescription = null,
                            modifier = modifier.size(36.dp)
                        )
                    }
                }

                // Text displaying the label "Progress" for the section.
                Text(text = "Progress", style = Typography.bodySmall)

                // ProgressVisualizer composable to visualize progress.
                ProgressVisualizer(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .wrapContentHeight(),
                    // Random data for demonstration purposes. Replace with actual data.
                    Random().ints(25, 0, 3).toList(),
                    questionsPerRow = 7
                )
            }
        }
    }


    // Composable function to display the recent sessions section.
    @Composable
    override fun RecentSessions(
        sessions: List<SessionMetadata>,
        getTopicsLabels: (String) -> List<String>,
        onClick: (SessionMetadata) -> Unit
    ) {
        // Calculate the window size for displaying recent sessions.
        val windowSize = maxOf(sessions.size - 1, 5)
        // Create an IntRange representing the window of visible sessions.
        val window = IntRange(0, maxOf(sessions.size - 1, 5))

        // MutableState for tracking the current page in the session window.
        var currentPage by remember {
            mutableIntStateOf(0)
        }

        // Calculate the total number of pages based on window size.
        val numberOfPages = sessions.size / windowSize + 1

        // Column to arrange the contents vertically.
        Column(
            modifier = Modifier.wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            // Composable function for displaying the headline of recent sessions.
            RecentSessionHeadline(
                numberOfPages = numberOfPages,
                currentPage = currentPage,
                onPageChanged = {
                    currentPage = it
                }
            )

            // AnimatedContent for smoothly transitioning between pages.
            AnimatedContent(targetState = currentPage, label = "") { currentPage ->
                // Column to arrange session cards vertically with spacing.
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    // Loop through sessions in the current window and create SessionCard for each.
                    for (index in numberOfPages * currentPage until numberOfPages * currentPage + window.last - 2) {
                        // Retrieve the session metadata at the current index.
                        sessions[index].also {
                            // Display a SessionCard for the current session.
                            SessionCard(
                                session = it,
                                getTopicsLabels = getTopicsLabels,
                                onClick = onClick
                            )
                        }
                    }
                }
            }
        }
    }


    // Composable function to display the headline of the recent sessions section.
    @Composable
    fun RecentSessionHeadline(numberOfPages: Int, currentPage: Int, onPageChanged: (Int) -> Unit) {
        // Row to arrange the contents horizontally with space between them.
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Column to arrange text contents vertically.
            Column {
                // Text displaying the main title of the recent sessions section.
                Text(text = "Your Recent Sessions")
                // Text providing additional information about the section.
                Text(
                    text = "See your recent quiz activity and stats",
                    style = Typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground.copy(0.25f)
                )
            }

            // Check if there is more than one page of recent sessions.
            if (numberOfPages > 1) {
                // Row to display page indicators with spacing between them.
                Row(
                    modifier = Modifier.wrapContentSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // Repeat for each page indicator.
                    repeat(numberOfPages) {
                        // Text displaying the page number.
                        Text(
                            text = (it + 1).toString(),
                            // Set color based on whether it's the current page or not.
                            color = if (currentPage == it) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.onBackground,
                            // Clickable modifier to handle page changes.
                            modifier = Modifier.clickable { onPageChanged(it) }
                        )
                    }
                }
            }
        }
    }


    // Composable function to display a session card.
    @Composable
    fun SessionCard(
        session: SessionMetadata,
        getTopicsLabels: (String) -> List<String>,
        onClick: (SessionMetadata) -> Unit
    ) {
        // MutableState to track the expansion state of the card.
        var isExpanded by remember { mutableStateOf(false) }

        // Card composable with custom modifier, click behavior, and color scheme.
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable {
                    // Invoke the onClick callback when the card is clicked.
                    onClick(session)
                    // Toggle the expansion state.
                    isExpanded = !isExpanded
                },
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
        ) {
            // Column to arrange the contents of the card vertically.
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .wrapContentSize(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top)
            ) {
                // Row displaying session status indicator and status text.
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Surface for the session status indicator bar.
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .width(3.dp)
                            .height(30.dp),
                        // Set color based on the session status.
                        color = when (session.status) {
                            SessionMetadata.COMPLETED -> Color.Green.copy(alpha = 0.5f)
                            SessionMetadata.QUITTED -> Color.Red.copy(alpha = 0.5f)
                            SessionMetadata.STARTED -> Color.Yellow.copy(alpha = 0.5f)
                            else -> Color.Transparent
                        }
                    ) {}
                    // Text displaying session details, including status and timestamp.
                    Text(
                        text = "Quiz ${
                            when (session.status) {
                                SessionMetadata.COMPLETED -> "finished"
                                SessionMetadata.QUITTED -> "stopped"
                                SessionMetadata.STARTED -> "started"
                                else -> ""
                            }
                        } on ${
                            SimpleDateFormat("mm/dd/yyyy").format(session.timestamp)
                        }",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                // AnimatedVisibility to conditionally show content when expanded.
                AnimatedVisibility(visible = isExpanded) {
                    // Column for additional content when the card is expanded.
                    Column(modifier = Modifier.wrapContentSize()) {
                        // Get the topics associated with the session.
                        val topics = getTopicsLabels(session.topicsUids)
                        // Text indicating the content type ("Courses").
                        Text(
                            text = "Courses",
                            style = Typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        // Display each topic as a row with a colored circle and text.
                        topics.onEach {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                // Colored circle representing the topic.
                                Surface(
                                    shape = CircleShape,
                                    color = MaterialTheme.colorScheme.secondaryContainer,
                                    modifier = Modifier.size(6.dp)
                                ) {
                                    // Empty surface for the circle.
                                }
                                // Text displaying the topic label.
                                Text(
                                    it,
                                    style = Typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onBackground.copy(0.25f)
                                )
                            }
                        }
                    }
                }
            }
        }
    }


    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    override fun NewSessionDialog(
        onDismiss: () -> Unit,
        topics: List<TopicMetadata>,
        onTopicSelected:(TopicMetadata)->Unit,
        selectedTopics:StateFlow<List<TopicMetadata>>,
        selectedQuestionCount : StateFlow<Int>,
        onQuestionCountChanged:(Int)->Unit,
        onSubmit: () -> Unit
    ) {

        val selected by selectedTopics.collectAsState()
        val questionCount by selectedQuestionCount.collectAsState()
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(dismissOnClickOutside = false, dismissOnBackPress = false)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
                    .background(
                        MaterialTheme.colorScheme.surfaceBright,
                        RoundedCornerShape(10.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = Modifier.wrapContentSize(),
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Create new Quiz",
                                style = Typography.headlineSmall,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                text = "You can pick maximum 5 courses",
                                style = Typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onBackground.copy(0.25f)
                            )
                        }
                        IconButton(onClick = onDismiss) {
                            Icon(
                                imageVector = Icons.Filled.FullscreenExit,
                                contentDescription = null
                            )
                        }
                    }
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        verticalArrangement = Arrangement.spacedBy(2.dp),
                        horizontalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        items(topics, key = { it.uid }) {
                            TopicCard(
                                modifier = Modifier.size(100.dp),
                                topicMetadata = it,
                                onClick = {

                                    onTopicSelected(it)
                                },
                                isInside = it in selected
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        Alignment.Start
                    ) {
                        Text(
                            text = "Quiz Length",
                            style = Typography.headlineSmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        FlowRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            horizontalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            val button1Color by animateColorAsState(
                                targetValue = if (questionCount == 5) MaterialTheme.colorScheme.secondary.copy(
                                    0.5f
                                ) else MaterialTheme.colorScheme.surface
                            )
                            val button2Color by animateColorAsState(
                                targetValue = if (questionCount == 10) MaterialTheme.colorScheme.secondary.copy(
                                    0.5f
                                ) else MaterialTheme.colorScheme.surface
                            )
                            val button3Color by animateColorAsState(
                                targetValue = if (questionCount == 15) MaterialTheme.colorScheme.secondary.copy(
                                    0.5f
                                ) else MaterialTheme.colorScheme.surface
                            )

                            Button(
                                onClick = { onQuestionCountChanged(5) },
                                modifier = Modifier.weight(1f, true),
                                shape = RoundedCornerShape(2.dp),
                                colors = ButtonDefaults.buttonColors(button1Color)
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(
                                        4.dp,
                                        Alignment.CenterVertically
                                    ), horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Short", fontSize = 10.sp)
                                    Text(text = "5 Questions", fontSize = 8.sp)
                                }
                            }
                            Button(
                                onClick = {onQuestionCountChanged(10) },
                                modifier = Modifier.weight(1f, true),
                                shape = RoundedCornerShape(2.dp),
                                colors = ButtonDefaults.buttonColors(button2Color)
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(
                                        4.dp,
                                        Alignment.CenterVertically
                                    ), horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Normal", fontSize = 8.sp)
                                    Text(text = "10 Questions", fontSize = 8.sp)
                                }
                            }
                            Button(
                                onClick = { onQuestionCountChanged(15) },
                                modifier = Modifier.weight(1f, true),
                                shape = RoundedCornerShape(2.dp),
                                colors = ButtonDefaults.buttonColors(button3Color)
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(
                                        4.dp,
                                        Alignment.CenterVertically
                                    ), horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Long", fontSize = 10.sp)
                                    Text(text = "15 Questions", fontSize = 8.sp)
                                }
                            }
                        }
                    }
                    Button(
                        onClick = { onSubmit()
                                    onDismiss()
                                  },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(2.dp),
                    ) {
                        Text(text = "Create New Quiz")
                        Icon(imageVector = Icons.Filled.Send, contentDescription = null)
                    }
                }
            }
        }
    }

    @Composable
    fun TopicCard(
        modifier: Modifier,
        topicMetadata: TopicMetadata,
        onClick: (TopicMetadata) -> Unit,
        isInside: Boolean
    ) {
        var triggerColorChange by remember { mutableStateOf(isInside) }
        val defaultGradient =
            Pair(MaterialTheme.colorScheme.surface, MaterialTheme.colorScheme.surface)
        val targetGradient = Pair(MaterialTheme.colorScheme.primary , MaterialTheme.colorScheme.secondary)
        val color1Animation by animateColorAsState(
            targetValue = if (triggerColorChange && isInside) targetGradient.first else defaultGradient.first,
            label = ""
        )
        val color2Animation by animateColorAsState(
            targetValue = if (triggerColorChange && isInside) targetGradient.second else defaultGradient.second,
            label = ""
        )
        Log.d("Test", "${topicMetadata.label} IsInside = $isInside")
        Surface(
            Modifier
                .wrapContentHeight(Alignment.CenterVertically)
                .wrapContentWidth(Alignment.Start)
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            color1Animation,
                            color2Animation
                        )
                    ),
                    shape = RoundedCornerShape(4.dp)

                )
                .clickable {
                    if(!isInside) triggerColorChange = true
                   // isInsideSwitch = !isInsideSwitch
                    onClick(topicMetadata)

                }
                .then(modifier),
            shape = RoundedCornerShape(4.dp),
            color = Color.Transparent,
            shadowElevation = 0.dp,
            tonalElevation = 0.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Row {
                    if (topicMetadata.imageUid != -1) {
                        Icon(
                            painter = painterResource(id = topicMetadata.uid),
                            contentDescription = null
                        )
                    }
                    Text(text = topicMetadata.label ,  fontSize = 12.sp ,color = MaterialTheme.colorScheme.onBackground.copy(0.75f) , maxLines = 4 , overflow = TextOverflow.Ellipsis)
                }
                val keyWorkds = topicMetadata.keyWords.split("/").filter { it.isNotBlank() }
                val content = buildString {
                    keyWorkds.onEachIndexed { index, s ->
                        if (index != keyWorkds.lastIndex) append(s + ",")
                        else append(s)
                    }
                }
                Text(
                    text = content,
                    style = Typography.bodySmall,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onBackground.copy(0.25f)
                )
            }
        }

    }
}
