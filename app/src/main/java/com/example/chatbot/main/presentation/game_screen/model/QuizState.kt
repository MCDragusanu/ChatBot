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
    data class MultiChoiceQuizState(val questionContent: String ,
                                    val questionUid:Long,
                                    val topicUid:Int,
                                    val topicName : String,
                                    val allAnswers:List<String>,
                                    val correctAnswerIndex : Int,
                                    val currentPickedAnswer: Int ,
                                    val isLoading:Boolean ) : QuizState(){
                                        fun isCorrect() = correctAnswerIndex == currentPickedAnswer
                                    }


    // Represents the state of an open-ended quiz.
    data class OpenEndedQuizState(val question: Question, val topicName:String,val conversation: List<Message>) : QuizState()
}
