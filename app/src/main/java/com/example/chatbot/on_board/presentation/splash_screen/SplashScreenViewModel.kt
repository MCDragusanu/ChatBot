package com.example.chatbot.on_board.presentation.splash_screen

import androidx.lifecycle.ViewModel
import com.example.chatbot.on_board.data.module.OnBoardModule

abstract class SplashScreenViewModel:ViewModel() {

    private lateinit var module: OnBoardModule

    fun setModule(onBoardModule: OnBoardModule) {
        this.module = onBoardModule
    }
}