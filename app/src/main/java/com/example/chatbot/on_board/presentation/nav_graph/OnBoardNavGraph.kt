package com.example.chatbot.on_board.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatbot.on_board.presentation.login_screen.LoginScreen
import com.example.chatbot.on_board.presentation.login_screen.LoginScreenViewModel
import com.example.chatbot.on_board.presentation.on_board_screen.OnBoardScreen
import com.example.chatbot.on_board.presentation.on_board_screen.OnBoardViewModel
import com.example.chatbot.on_board.presentation.registration_screen.RegistrationScreen
import com.example.chatbot.on_board.presentation.registration_screen.RegistrationScreenViewModel
import com.example.chatbot.on_board.presentation.splash_screen.SplashScreen
import com.example.chatbot.on_board.presentation.splash_screen.SplashScreenViewModel

/**
 * An object representing the navigation graph for the onboarding process, defining the Composable screens and navigation flow.
 */
object OnBoardNavGraph {
    /**
     * Composable function that defines the main navigation flow for the onboarding process.
     *
     * @param loginScreenViewModel The ViewModel for the login screen.
     * @param registrationScreenViewModel The ViewModel for the registration screen.
     * @param onBoardViewModel The ViewModel for the onboarding screen.
     * @param splashScreenViewModel The ViewModel for the splash screen.
     * @param loginScreen The login screen Composable.
     * @param splashScreen The splash screen Composable.
     * @param registrationScreen The registration screen Composable.
     * @param onBoardScreen The onboarding screen Composable.
     * @param onCompletedAuth A callback function to be invoked when the user completes authentication, passing the user's unique identifier.
     */
    @Composable
    fun Main(
        loginScreenViewModel: LoginScreenViewModel,
        loginScreen: LoginScreen,
        registrationScreen: RegistrationScreen,
        registrationScreenViewModel: RegistrationScreenViewModel,
        onBoardScreen: OnBoardScreen,
        onBoardViewModel: OnBoardViewModel,
        splashScreen: SplashScreen,
        splashScreenViewModel: SplashScreenViewModel,
        onCompletedAuth: (String) -> Unit
    ) {
        // Create a navigation controller to manage navigation between Composables.
        val navController = rememberNavController()

        // Define the navigation flow using Jetpack Compose's NavHost and composable functions.
        NavHost(navController, startDestination = loginScreen.dest) {
            composable(splashScreen.dest) {
                // Display the splash screen and handle navigation to other screens.
                splashScreen.Main(
                    splashScreenViewModel = splashScreenViewModel,
                    onUserIsSignedIn = onCompletedAuth,
                    onUserNotFound = {
                        // Navigate to the login screen.
                        navController.popBackStack()
                        navController.navigate(loginScreen.dest)
                    }
                )
            }
            composable(loginScreen.dest) {
                // Display the login screen and handle navigation to other screens.
                loginScreen.Main(
                    viewModel = loginScreenViewModel,
                    onLoginCompleted = onCompletedAuth,
                    onRegister = {
                        // Navigate to the onboarding screen.
                       // navController.navigate(onBoardScreen.dest)
                    }
                )
            }
            composable(registrationScreen.dest) {
                // Display the registration screen.
                registrationScreen.Main(
                    viewModel = registrationScreenViewModel,
                    onCompletedRegistration = {
                        navController.popBackStack(registrationScreen.dest , true)
                        onCompletedAuth(it)
                    }
                )
            }
            composable(onBoardScreen.dest) {
                // Display the onboarding screen and handle navigation to the registration screen.
                onBoardScreen.Main(
                    viewModel = onBoardViewModel,
                    onRegister = {
                        // Navigate to the registration screen.
                        navController.navigate(registrationScreen.dest)
                    }
                )
            }
        }
    }
}
