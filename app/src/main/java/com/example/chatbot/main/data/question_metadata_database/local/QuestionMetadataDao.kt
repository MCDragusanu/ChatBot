package com.example.chatbot.main.data.question_metadata_database.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.chatbot.main.data.question_metadata_database.entity.QuestionMetadata

@Dao
interface QuestionMetadataDao {

    @Insert
    suspend fun addQuestionMetadata(metadata: QuestionMetadata)

    @Delete
    suspend fun removeMetadata(metadata: QuestionMetadata)

    @Update
    suspend fun updateMetadata(metadata: QuestionMetadata)

    @Query("SELECT * from question_metadata_table where topicUid = :topicUid")
    suspend fun getAllMetadatForTopic(topicUid:Int):List<QuestionMetadata>

    @Query("SELECT * from question_metadata_table where questionUid = :questionUid")
    suspend fun getMetadataByQuestionUid(questionUid:Int): QuestionMetadata?


}