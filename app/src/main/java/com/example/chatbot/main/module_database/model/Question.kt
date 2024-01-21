package com.example.chatbot.main.module_database.model

import androidx.room.Entity

@Entity(tableName = "question_table")
data class Question(val uid : Int,
                    val content :String,
                    val topicUid : Int,
                    val allAnswers : List<String>,
                    val paragraph : String,
                    val correctAnswer:Int,
                    val questionType : Int
) {
    enum class QuestionType {
        SelfAssessment,
        OfficialAssessment,
    }
}