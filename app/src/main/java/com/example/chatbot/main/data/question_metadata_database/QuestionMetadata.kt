package com.example.chatbot.main.data.question_metadata_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question_metadata_table")
data class QuestionMetadata(@PrimaryKey val uid:Long,
                            val grade:Float ,
                            val statusCode:Int ,
                            val questionUid:Int ,
                            val topicUid:Int ,
                            val weight:Double) {
    companion object {
        const val DEFAULT = 0
        const val COMPLETED = 1
        const val WRONG = 2
    }
}