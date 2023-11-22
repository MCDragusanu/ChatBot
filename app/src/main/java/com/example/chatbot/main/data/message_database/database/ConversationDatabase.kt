package com.example.chatbot.main.data.message_database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chatbot.main.data.message_database.dao.SessionMetadataDao
import com.example.chatbot.main.data.message_database.model.Instruction
import com.example.chatbot.main.data.message_database.model.Message
import com.example.chatbot.main.data.message_database.model.SessionMetadata
import com.example.chatbot.main.data.message_database.model.ThreadMetadata

@Database(entities = [Instruction::class , Message::class , ThreadMetadata::class , SessionMetadata::class] , version = 1)
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