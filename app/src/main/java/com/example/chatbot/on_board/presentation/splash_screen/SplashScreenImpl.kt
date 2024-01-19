package com.example.chatbot.on_board.presentation.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.chatbot.R
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import md_theme_light_primary
import md_theme_light_secondary

object SplashScreenImpl:SplashScreen() {
    @Composable
    override fun Main(
        splashScreenViewModel: SplashScreenViewModel,
        onUserNotFound: () -> Unit,
        onUserIsSignedIn: (String) -> Unit
    ) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            BackgroundLayer(modifier = Modifier.fillMaxSize())
            ForegroundLayer(modifier = Modifier.fillMaxSize())
        }
        LaunchedEffect(key1 = true) {
            delay(500)
            val uid = splashScreenViewModel.checkAccount()
            if (uid == null) onUserNotFound()
            else onUserIsSignedIn(uid)
        }
    }

    @Composable
    override fun LogoImage(modifier: Modifier, imageRes: Int) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = modifier
        )
    }

    @Composable
    override fun BackgroundLayer(modifier: Modifier) {
        Surface(modifier = modifier, color = MaterialTheme.colorScheme.background) {}
    }

    @Composable
    override fun ForegroundLayer(modifier: Modifier) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            LogoImage(modifier = Modifier.size(250.dp), imageRes = R.drawable.codelingo)
        }
    }
}