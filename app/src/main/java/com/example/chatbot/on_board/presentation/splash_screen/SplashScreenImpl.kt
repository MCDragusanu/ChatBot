package com.example.chatbot.on_board.presentation.splash_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object SplashScreenImpl:SplashScreen() {
    @Composable
    override fun Main(
        splashScreenViewModel: SplashScreenViewModel,
        onUserNotFound: () -> Unit,
        onUserIsSignedIn: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    @Composable
    override fun LogoImage(modifier: Modifier, imageRes: Int) {
        TODO("Not yet implemented")
    }

    @Composable
    override fun BackgroundLayer(modifier: Modifier) {
        TODO("Not yet implemented")
    }

    @Composable
    override fun ForegroundLayer(modifier: Modifier) {
        TODO("Not yet implemented")
    }
}