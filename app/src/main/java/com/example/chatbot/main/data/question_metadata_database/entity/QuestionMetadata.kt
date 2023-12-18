package com.example.chatbot.main.data.question_metadata_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "question_metadata_table")
class QuestionMetadata(val userUid:String= "DEFAULT_USER",
                       val questionRowUid : Int = 0,
                       val currentGrade:Double = -1.0,
                       val weight:Double = 10.0,
                       val status:Int = DEFAULT
    ) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    companion object {
        // Constants representing different question statuses
        const val DEFAULT = 0
        const val COMPLETED = 1
        const val WRONG = 2
    }
}