package com.example.chatbot.main.data.message_database.model

import androidx.room.Entity

@Entity(tableName = "instruction_table")
class Instruction(val uid:Long , val content:String)