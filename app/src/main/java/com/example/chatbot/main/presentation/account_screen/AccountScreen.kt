package com.example.chatbot.main.presentation.account_screen

import androidx.compose.runtime.Composable

interface AccountScreen {

    @Composable
    fun Main(viewModel: AccountScreenViewModel , onSignOut:()->Unit , onDeleteAccount:()->Unit , )
}