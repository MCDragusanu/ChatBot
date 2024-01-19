package com.example.chatbot.on_board.presentation.splash_screen

import androidx.lifecycle.ViewModel
import com.example.chatbot.on_board.data.module.OnBoardModule
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

open class SplashScreenViewModel:ViewModel() {

    private lateinit var module: OnBoardModule

    private val _userUid = MutableStateFlow<String?>(null)
    val userUid = _userUid.asStateFlow()
    fun setModule(onBoardModule: OnBoardModule) {
        this.module = onBoardModule
    }
    fun checkAccount() : String?{
       return FirebaseAuth.getInstance().uid
    }

}