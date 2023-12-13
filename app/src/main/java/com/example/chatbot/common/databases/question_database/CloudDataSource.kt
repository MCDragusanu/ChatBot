package com.example.chatbot.common.databases.question_database

interface   CloudDataSource {

    suspend fun addTopicsAndQuestions(topic: TopicMetadata):Result<Unit>


    suspend fun getTopic(topicUid:Int):Result<TopicMetadata>


}