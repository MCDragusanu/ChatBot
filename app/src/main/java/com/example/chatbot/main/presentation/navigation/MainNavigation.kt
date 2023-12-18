package com.example.chatbot.main.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatbot.main.presentation.home.HomeScreen
import com.example.chatbot.main.presentation.home.HomeScreenViewModel

object MainNavigation {

    @Composable
    operator fun invoke(homeScreen: HomeScreen ,
                        homeScreenViewModel:HomeScreenViewModel,
                        ) {

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = homeScreen.dest) {
            composable(route = homeScreen.dest) {
                 homeScreen.Main(homeScreenViewModel = homeScreenViewModel, onStartNewSession = {

                 })
            }
        }
    }
}