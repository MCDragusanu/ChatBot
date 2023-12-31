package com.example.chatbot.main.presentation.game_screen.controllers

import com.example.chatbot.main.presentation.game_screen.model.QuizEvent
import com.example.chatbot.main.presentation.game_screen.model.QuizState
import com.example.chatbot.main.presentation.game_screen.layouts.QuizLayout
import kotlinx.coroutines.flow.StateFlow

class MultiChoiceController() : QuizController() {
    override var quizLayout: QuizLayout
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun loadResources() {
        TODO("Not yet implemented")
    }

    override fun presentState(): StateFlow<QuizState?> {
        TODO("Not yet implemented")
    }

    override fun onEvent(event: QuizEvent) {
        TODO("Not yet implemented")
    }
}