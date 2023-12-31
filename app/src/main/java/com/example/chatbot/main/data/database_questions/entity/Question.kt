package com.example.chatbot.main.data.database_questions.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.chatbot.main.data.database_messages.model.QuizMetadata

@Entity(tableName = "question_table")
class Question(@PrimaryKey(autoGenerate = false)
               val  uid:Int = -1,
               val questionUid:Int  = -1,
               val questionContent:String= "",
               val correctAnswer: String = "",
               val topicUid:Int = -1,
               val questionType:String = OPEN_ENDED,) {
    companion object{
        const val OPEN_ENDED = QuizMetadata.OPEN_ENDED
        const val MULTICHOICE = QuizMetadata.MULTI_CHOICE
    }
}