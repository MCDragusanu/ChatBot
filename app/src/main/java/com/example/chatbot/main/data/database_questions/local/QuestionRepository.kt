package com.example.chatbot.main.data.database_questions.local

import com.example.chatbot.main.data.database_questions.entity.QuestionMetadata
import com.example.chatbot.main.data.database_questions.entity.Question
import com.example.chatbot.main.data.database_questions.entity.TopicMetadata
import com.example.chatbot.main.domain.instruction_factory.InstructionFactory

interface QuestionRepository {

    // Questions
    suspend fun addQuestionRow(question: Question)
    suspend fun addQuestionMetadata(questionMetadata: QuestionMetadata)
    suspend fun removeQuestionMetadata(metadata: QuestionMetadata)
    suspend fun updateQuestionMetadata(metadata: QuestionMetadata)
    suspend fun getAllMetadataForTopic(topicUid: Int, userUid: String): List<QuestionMetadata>
    suspend fun getMetadataByQuestionUid(questionUid: Long, userUid: String): QuestionMetadata?

    // Weight Matrix
    suspend fun buildWeightMatrix(userUid: String): Array<Array<Pair<Double , Long>>>

    // Caching
    suspend fun noTopicsCached(): Boolean
    suspend fun noQuestionsCached(): Boolean

    // Topics
    suspend fun addTopic(topic: TopicMetadata)
    suspend fun getAllTopics(): List<TopicMetadata>

    suspend fun getQuestionByUid(questionUid:Long):Question?

    fun getInstructionFactory() : InstructionFactory{
        return InstructionFactory()
    }

    suspend fun getTopicName(topicUid:Int): String
}