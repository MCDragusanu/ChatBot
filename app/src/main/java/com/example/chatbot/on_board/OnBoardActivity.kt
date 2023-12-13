package com.example.chatbot.on_board


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.chatbot.main.MainActivity
import com.example.chatbot.on_board.data.module.OnBoardModule
import com.example.chatbot.on_board.presentation.login_screen.LoginScreenImpl
import com.example.chatbot.on_board.presentation.login_screen.LoginScreenViewModelImpl
import com.example.chatbot.on_board.presentation.nav_graph.OnBoardNavGraph
import com.example.chatbot.on_board.presentation.on_board_screen.OnBoardScreenImpl
import com.example.chatbot.on_board.presentation.on_board_screen.OnBoardViewModelImpl
import com.example.chatbot.on_board.presentation.registration_screen.RegistrationScreenImpl
import com.example.chatbot.on_board.presentation.registration_screen.RegistrationScreenViewModelImpl
import com.example.chatbot.on_board.presentation.splash_screen.SplashScreenImpl
import com.example.chatbot.on_board.presentation.splash_screen.SplashScreenViewModelImpl
import com.example.chatbot.common.databases.question_database.CloudDataSource
import com.example.chatbot.common.databases.question_database.FirebaseCloudDatabase
import com.example.chatbot.common.databases.question_database.Question
import com.example.chatbot.common.databases.question_database.TopicMetadata
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * The main activity for the onboarding process.
 * This activity serves as the entry point for the onboarding flow and transitions to the main application after authentication.
 */
class OnBoardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create an OnBoardModule with test mode enabled.
        val onBoardModule = OnBoardModule.getModule(isInTestMode = false)

        // Initialize the LoginScreenViewModel and set the OnBoardModule dependency.
        val loginScreenViewModel by viewModels<LoginScreenViewModelImpl>().apply {
            this.value.initModule(onBoardModule)
        }

        // Initialize the RegistrationScreenViewModel and set the OnBoardModule dependency.
        val registrationScreenViewModel by viewModels<RegistrationScreenViewModelImpl>().apply {
            this.value.initModule(onBoardModule)
        }

        // Initialize the OnBoardViewModel and set the OnBoardModule dependency.
        val onBoardViewModel by viewModels<OnBoardViewModelImpl>().apply {
            this.value.setModule(onBoardModule)
        }

        // Initialize the SplashScreenViewModel and set the OnBoardModule dependency.
        val splashScreenViewModel by viewModels<SplashScreenViewModelImpl>().apply {
            this.value.setModule(onBoardModule)
        }

        postTopic()

        // Set the content view for the activity.
        setContent {
            // The Composable content for the OnBoardActivity can be defined here.
            OnBoardNavGraph.Main(
                loginScreenViewModel = loginScreenViewModel,
                loginScreen = LoginScreenImpl,
                registrationScreen = RegistrationScreenImpl,
                registrationScreenViewModel = registrationScreenViewModel,
                onBoardScreen = OnBoardScreenImpl,
                onBoardViewModel = onBoardViewModel,
                splashScreen = SplashScreenImpl,
                splashScreenViewModel = splashScreenViewModel,
                onCompletedAuth = { startMainActivity(it) }
            )
        }
    }

    /**
     * Start the main application after successful authentication.
     *
     * @param userUid The unique identifier of the authenticated user.
     */
    private fun startMainActivity(userUid: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("USER_UID", userUid)
        startActivity(intent)
        this.finish()
    }

    fun postTopic() {

        val dataSource: CloudDataSource = FirebaseCloudDatabase()
        val questionList = listOf<Question>(
            Question(
                uid = 1,
                topicUid = 1,
                content = "What is the main concept of Object-Oriented Programming?",
                hints = listOf("Think about organizing code around objects and their interactions.")
            ),
            Question(
                uid = 2,
                topicUid = 1,
                content = "Explain the concept of a class in OOP.",
                hints = listOf("Consider how a class serves as a blueprint for objects.")
            ),
            Question(
                uid = 3,
                topicUid = 1,
                content = "How does inheritance work in OOP?",
                hints = listOf("Think about how a class can inherit properties and behaviors from another class.")
            ),
            Question(
                uid = 4,
                topicUid = 1,
                content = "What is polymorphism in OOP?",
                hints = listOf("Consider how objects of different classes can be treated as objects of a common base class.")
            ),
            Question(
                uid = 5,
                topicUid = 1,
                content = "Explain the concept of encapsulation.",
                hints = listOf("Think about bundling data and methods that operate on the data within a class.")
            )
        )
        //De fiecare data aveti grija sa incrementati uid ul
        val topic = TopicMetadata(
            uid = 1,
            label = "Object-Oriented Programming",
            keyWords = listOf(
                "OOP",
                "Object-Oriented Programming",
                "Classes",
                "Inheritance",
                "Polymorphism",
                "Encapsulation",
                "Abstraction"
            ),
            questionList = questionList
        )
        CoroutineScope(Dispatchers.IO).launch {
            dataSource.addTopicsAndQuestions(topic)
        }
    }
}
