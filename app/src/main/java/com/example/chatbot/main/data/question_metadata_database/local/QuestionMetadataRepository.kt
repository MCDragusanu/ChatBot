package com.example.chatbot.main.data.question_metadata_database.local

import com.example.chatbot.main.data.question_metadata_database.entity.QuestionMetadata
import com.example.chatbot.main.data.question_metadata_database.entity.QuestionRow
import com.example.chatbot.main.data.question_metadata_database.entity.TopicMetadata

interface QuestionRepository {

    suspend fun addQuestionRow(question: QuestionRow)

    suspend fun addQuestionMetadata(questionMetadata: QuestionMetadata)
    suspend fun removeMetadata(metadata: QuestionRow)

    suspend fun updateMetadata(metadata: QuestionRow)

    suspend fun getAllMetadataForTopic(topicUid:Int , userUid: String):List<QuestionMetadata>

    suspend fun getMetadataByQuestionUid(uid:Int , userUid:String): QuestionMetadata?

    suspend fun buildWeightMatrix(topics:List<Int>, userUid: String):Array<Array<Double>>

    suspend fun noTopicsCached():Boolean

    suspend fun noQuestionsCached():Boolean

    suspend fun addTopic(topic: TopicMetadata)

    suspend fun getAllTopics():List<TopicMetadata>

}