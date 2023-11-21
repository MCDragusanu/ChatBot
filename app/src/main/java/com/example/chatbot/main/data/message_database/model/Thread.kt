package com.example.chatbot.main.data.message_database.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "threads_table")
class Thread(@PrimaryKey val uid:Long , val sessionUid:Long , val questionUid:Long)