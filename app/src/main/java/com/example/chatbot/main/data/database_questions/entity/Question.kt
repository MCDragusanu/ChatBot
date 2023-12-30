package com.example.chatbot.main.data.database_questions.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question_table")
class Question(@PrimaryKey(autoGenerate = false)
               val  uid:Int = -1,
               val questionUid:Int  = -1,
               val questionContent:String= "",
               val correctAnswer: String = "",
               val topicUid:Int = -1,
               val questionType:String = "Open-Ended",) {
}