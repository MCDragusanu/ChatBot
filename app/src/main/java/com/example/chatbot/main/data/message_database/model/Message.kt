package com.example.chatbot.main.data.message_database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "message_table")
class Message (@PrimaryKey val uid:Long , val threadUid:String , val content:String , val sender:Int) {
    companion object{
        const val USER = 0
        const val BOT = 1
        const val SYSTEM = 2
    }
    fun isSentByUser() = this.sender == USER

    fun isSentByGPT() = this.sender == BOT

    fun isSystemMessage() = this.sender == SYSTEM
}