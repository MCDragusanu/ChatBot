package com.example.chatbot.main.data.question_metadata_database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface QuestionMetadataRepository {

    suspend fun addQuestionMetadata(metadata: QuestionMetadata)

    suspend fun removeMetadata(metadata: QuestionMetadata)

    suspend fun updateMetadata(metadata: QuestionMetadata)

    suspend fun getAllMetadatForTopic(topicUid:Int):List<QuestionMetadata>

    suspend fun getMetadataByQuestionUid():QuestionMetadata?

    suspend fun buildCoeffMatrix(topics:List<Int>):Array<Array<Double>>
}