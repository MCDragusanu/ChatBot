package com.example.chatbot.main.data.database_messages.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chatbot.main.data.database_messages.dao.SessionMetadataDao
import com.example.chatbot.main.data.database_messages.model.Instruction
import com.example.chatbot.main.data.database_messages.model.Message
import com.example.chatbot.main.data.database_messages.model.SessionMetadata
import com.example.chatbot.main.data.database_messages.model.QuizMetadata

@Database(entities = [Instruction::class , Message::class , QuizMetadata::class , SessionMetadata::class] , version = 2)
abstract class ConversationDatabase : RoomDatabase() {

    abstract val sessionMetadataDao: SessionMetadataDao

    companion object {
        private var instance: ConversationDatabase? = null

        fun getInstance(context: Context): ConversationDatabase {
            return instance ?: Room.databaseBuilder(
                context,
                ConversationDatabase::class.java,
                "conversation_database"
            ).fallbackToDestructiveMigration().build().also {
                instance = it
            }
        }
    }
}