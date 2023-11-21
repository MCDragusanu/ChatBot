package com.example.chatbot.main.data.message_database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "session_table")
class Session(val userUid:String , val timestamp: Long , val topicsUids:String , val instructionUid:Long){
    @PrimaryKey(autoGenerate = true) var uid:Int = 0
}
