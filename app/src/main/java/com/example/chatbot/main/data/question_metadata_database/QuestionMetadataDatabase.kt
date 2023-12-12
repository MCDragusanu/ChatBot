package com.example.chatbot.main.data.question_metadata_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QuestionMetadata::class] , version = 1)
abstract class QuestionMetadataDatabase:RoomDatabase() {

    abstract val dao: QuestionMetadataDao

    companion object {
        private var instance: QuestionMetadataDatabase? = null
        fun getInstance(context: Context): QuestionMetadataDatabase {
            return instance ?: Room.databaseBuilder(
                context,
                QuestionMetadataDatabase::class.java,
                "question_metadata_table"
            ).fallbackToDestructiveMigration().build().also {
                instance = it
            }
        }
    }
}