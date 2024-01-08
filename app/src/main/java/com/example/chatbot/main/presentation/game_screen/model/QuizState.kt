package com.example.chatbot.main.presentation.game_screen.model

import com.example.chatbot.main.data.database_messages.model.Message
import com.example.chatbot.main.data.database_questions.entity.Question

sealed class QuizState() {

    enum class PossibleState{
        Loading,
        FailedToLoad,
        Default,
        Completed
    }
    // Represents the state of a multiple-choice quiz.
    data class MultiChoiceQuizState(val question: Question, val currentPickedAnswer: Int , val isLoading:Boolean ) : QuizState()

    // Represents the state of an open-ended quiz.
    data class OpenEndedQuizState(val question: Question, val conversation: List<Message>) : QuizState()
}
