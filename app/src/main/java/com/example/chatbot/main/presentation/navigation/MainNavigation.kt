package com.example.chatbot.main.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.chatbot.main.presentation.game_screen.GameController
import com.example.chatbot.main.presentation.game_screen.GameScreen
import com.example.chatbot.main.presentation.home.HomeScreen
import com.example.chatbot.main.presentation.home.HomeScreenViewModel

object MainNavigation {

    @Composable
    operator fun invoke(
        homeScreen: HomeScreen,
        gameScreen: GameScreen,
        gameController: GameController,
        homeScreenViewModel: HomeScreenViewModel,
    ) {

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = homeScreen.dest) {
            composable(route = homeScreen.dest,) {
                homeScreen.Main(homeScreenViewModel = homeScreenViewModel, onStartNewSession = {
                    navController.navigate(gameScreen.dest + "/$it")
                })
            }
            composable(
                route = gameScreen.dest + "/{sessionUid}",
                arguments = listOf(navArgument("sessionUid") {
                    this.type = NavType.LongType

                })
            ) {
                val sessionUid = it.arguments?.getLong("sessionUid") ?: -1
                gameController.setSessionUid(sessionUid)
                gameScreen.Main(controller = gameController)
            }
        }
    }
}