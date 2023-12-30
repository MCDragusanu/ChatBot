package com.example.chatbot.main.data.database_questions.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chatbot.main.data.database_questions.entity.QuestionMetadata
import com.example.chatbot.main.data.database_questions.entity.Question
import com.example.chatbot.main.data.database_questions.entity.TopicMetadata

@Database(entities = [Question::class , QuestionMetadata::class , TopicMetadata::class] , version = 2)
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