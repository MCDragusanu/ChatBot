package com.example.chatbot.main.module_database.model

import androidx.room.Entity

@Entity(tableName = "topic_table")
data class Topic(val uid : Int ,
                 val moduleUid:Int,
                 val titleField : String ,
                 val descriptionField:String ,
                 val objectivesField : List<String> ,
                 val contentField :String,
                 val activityField:String)