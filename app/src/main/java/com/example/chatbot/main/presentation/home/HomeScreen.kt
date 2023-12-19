package com.example.chatbot.main.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chatbot.common.databases.user_database.User
import com.example.chatbot.main.data.database_messages.model.SessionMetadata
import com.example.chatbot.main.data.database_questions.entity.TopicMetadata

/**
 * Abstract class representing a common interface for the home screen in a Jetpack Compose application.
 */
abstract class HomeScreen : com.example.chatbot.common.ui.util.Destination("HomeScreen") {

    /**
     * Abstract function to define the main content of the home screen.
     *
     * @param homeScreenViewModel ViewModel providing data for the home screen.
     * @param onStartNewSession Callback to be invoked when starting a new session.
     */
    @Composable
    abstract fun Main(homeScreenViewModel: HomeScreenViewModel, onStartNewSession: (Long) -> Unit)

    /**
     * Abstract function to define the headline component of the home screen.
     *
     * @param currentUser The current user for whom the home screen is displayed.
     * @param onSettingsClicked Callback to be invoked when the settings icon is clicked.
     * @param onAccountClicked Callback to be invoked when the account icon is clicked.
     */
    @Composable
    abstract fun Headline(currentUser: User, onSettingsClicked: () -> Unit, onAccountClicked: () -> Unit)

    /**
     * Abstract function to define the statistics card component of the home screen.
     *
     * @param modifier Modifier for styling the stats card.
     * @param topicMetadata Metadata of the topic for which stats are displayed.
     * @param questionsStatus List of integers representing the status of questions for the topic.
     */
    @Composable
    abstract fun StatsCard(modifier: Modifier, topicMetadata: TopicMetadata, questionsStatus: List<Int>)

    /**
     * Abstract function to define the recent sessions component of the home screen.
     *
     * @param sessions List of recent session metadata.
     * @param getTopicsLabels Function to get topic labels from their UIDs.
     * @param onClick Callback to be invoked when a recent session is clicked.
     */
    @Composable
    abstract fun RecentSessions(
        sessions: List<SessionMetadata>,
        getTopicsLabels: (String) -> List<String>,
        onClick: (SessionMetadata) -> Unit
    )

    /**
     * Abstract function to define a new session dialog component.
     *
     * @param onDismiss Callback to be invoked when the dialog is dismissed.
     * @param onSubmit Callback to be invoked when submitting a new session.
     *                 Provides selected topics, difficulty level, and number of questions.
     */
    @Composable
    abstract fun NewSessionDialog(
        onDismiss: () -> Unit,
        onSubmit: (List<TopicMetadata>, difficultyLevel: Int, numberOfQuestions: Int) -> Unit
    )
}

