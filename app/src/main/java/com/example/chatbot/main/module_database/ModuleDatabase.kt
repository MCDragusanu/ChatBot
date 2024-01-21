package com.example.chatbot.main.module_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chatbot.main.module_database.dao.ModuleDao
import com.example.chatbot.main.module_database.model.Module
import com.example.chatbot.main.module_database.model.Question
import com.example.chatbot.main.module_database.model.Topic
import com.example.chatbot.main.module_database.model.UserAnswer

@Database(entities = [Module::class , Question::class , Topic::class , UserAnswer::class] , version = 1)
abstract class ModuleDatabase : RoomDatabase() {
    abstract val dao: ModuleDao

    companion object {
        private var instance: ModuleDatabase? = null
        fun getInstance(context: Context): ModuleDatabase {
            return instance ?: Room.databaseBuilder(
                context,
                ModuleDatabase::class.java,
                "module_database"
            ).fallbackToDestructiveMigration().build().also {
                this.instance = it
            }
        }
    }
}