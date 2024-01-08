package com.example.chatbot.main.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.chatbot.main.presentation.game_screen.layouts.GameLayoutContainer
import com.example.chatbot.main.presentation.game_screen.state_manager.SessionStateManager
import com.example.chatbot.main.presentation.home.HomeScreen
import com.example.chatbot.main.presentation.home.HomeScreenViewModel

object MainNavigation {

    @Composable
    operator fun invoke(
        homeScreen: HomeScreen,
        sessionStateManager: SessionStateManager,
        homeScreenViewModel: HomeScreenViewModel,
    ) {

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = homeScreen.dest) {
            composable(route = homeScreen.dest,) {
                homeScreen.Main(homeScreenViewModel = homeScreenViewModel, onStartNewSession = {
                    Log.d("Navigation" , "Nav to sessionUid = $it")
                    navController.navigate(GameLayoutContainer.dest + "/$it")
                })
            }
            composable(
                route = GameLayoutContainer.dest + "/{sessionUid}",
                arguments = listOf(navArgument("sessionUid") {
                    this.type = NavType.LongType

                })
            ) {

                val sessionUid = it.arguments?.getLong("sessionUid") ?: -1
                Log.d("Navigation" , "Landed to sessionUid = $it")
                LaunchedEffect(key1 = true){
                    sessionStateManager.initGame(sessionUid)
                }
                GameLayoutContainer(sessionStateManager , onBackIsPressed = {
                    navController.popBackStack()
                })
            }
        }
    }
}