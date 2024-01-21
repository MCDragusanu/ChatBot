package com.example.chatbot.main.module_database.model

import androidx.room.Entity

@Entity(tableName = "module_table")
data class Module(val uid : Int , val title : String)