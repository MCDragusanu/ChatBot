package com.example.chatbot.on_board


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.chatbot.MainActivity
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

/**
 * The main activity for the onboarding process.
 * This activity serves as the entry point for the onboarding flow and transitions to the main application after authentication.
 */
class OnBoardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create an OnBoardModule with test mode enabled.
        val onBoardModule = OnBoardModule.getModule(isInTestMode = true)

        // Initialize the LoginScreenViewModel and set the OnBoardModule dependency.
        val loginScreenViewModel by viewModels<LoginScreenViewModelImpl>().apply {
            this.value.initModule(onBoardModule)
        }

        // Initialize the RegistrationScreenViewModel and set the OnBoardModule dependency.
        val registrationScreenViewModel by viewModels<RegistrationScreenViewModelImpl>().apply {
            this.value.setModule(onBoardModule)
        }

        // Initialize the OnBoardViewModel and set the OnBoardModule dependency.
        val onBoardViewModel by viewModels<OnBoardViewModelImpl>().apply {
            this.value.setModule(onBoardModule)
        }

        // Initialize the SplashScreenViewModel and set the OnBoardModule dependency.
        val splashScreenViewModel by viewModels<SplashScreenViewModelImpl>().apply {
            this.value.setModule(onBoardModule)
        }

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
}
