package com.example.chatbot.common.databases.question_database

interface   CloudDataSource {

    suspend fun addTopicsAndQuestions(topic: Topic):Result<Unit>


    suspend fun getTopic(topicUid:Int):Result<Topic>


}