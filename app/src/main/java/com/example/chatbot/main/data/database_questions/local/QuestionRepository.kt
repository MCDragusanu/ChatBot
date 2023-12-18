package com.example.chatbot.main.data.database_questions.local

import com.example.chatbot.main.data.database_questions.entity.QuestionMetadata
import com.example.chatbot.main.data.database_questions.entity.QuestionRow
import com.example.chatbot.main.data.database_questions.entity.TopicMetadata

interface QuestionRepository {

    // Questions
    suspend fun addQuestionRow(question: QuestionRow)
    suspend fun addQuestionMetadata(questionMetadata: QuestionMetadata)
    suspend fun removeQuestionMetadata(metadata: QuestionRow)
    suspend fun updateQuestionMetadata(metadata: QuestionRow)
    suspend fun getAllMetadataForTopic(topicUid: Int, userUid: String): List<QuestionMetadata>
    suspend fun getMetadataByQuestionUid(uid: Int, userUid: String): QuestionMetadata?

    // Weight Matrix
    suspend fun buildWeightMatrix(topics: List<Int>, userUid: String): Array<Array<Double>>

    // Caching
    suspend fun noTopicsCached(): Boolean
    suspend fun noQuestionsCached(): Boolean

    // Topics
    suspend fun addTopic(topic: TopicMetadata)
    suspend fun getAllTopics(): List<TopicMetadata>
}