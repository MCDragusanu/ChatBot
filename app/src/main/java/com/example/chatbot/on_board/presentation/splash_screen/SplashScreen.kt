package com.example.chatbot.on_board.presentation.splash_screen

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chatbot.common.ui.util.Destination

/**
 * An abstract class representing a splash screen with Jetpack Compose components and related functionality.
 *
 * This class extends the [Destination] class and serves as the destination identifier for the splash screen within a navigation graph.
 */
abstract class SplashScreen : Destination("SplashScreen") {
    /**
     * Composable function for the main splash screen view.
     *
     * @param splashScreenViewModel The ViewModel for managing the splash screen.
     * @param onUserNotFound A callback function to navigate to the login screen or perform login-related actions.
     * @param onUserIsSignedIn A callback function to start the main activity with the user's unique identifier.
     */
    @Composable
    abstract fun Main(splashScreenViewModel: SplashScreenViewModel, onUserNotFound: () -> Unit, onUserIsSignedIn: (String) -> Unit)

    /**
     * Composable function for the logo image.
     *
     * @param modifier The modifier to apply to the Composable element.
     * @param imageRes The drawable resource ID representing the logo image.
     */
    @Composable
    abstract fun LogoImage(modifier: Modifier, @DrawableRes imageRes: Int)

    /**
     * Composable function for the background layer of the splash screen.
     *
     * @param modifier The modifier to apply to the Composable element.
     */
    @Composable
    abstract fun BackgroundLayer(modifier: Modifier)

    /**
     * Composable function for the foreground layer of the splash screen.
     *
     * @param modifier The modifier to apply to the Composable element.
     */
    @Composable
    abstract fun ForegroundLayer(modifier: Modifier)
}