package com.example.chatbot.main.data.database_questions.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.chatbot.main.data.database_questions.entity.QuestionMetadata
import com.example.chatbot.main.data.database_questions.entity.Question
import com.example.chatbot.main.data.database_questions.entity.TopicMetadata

/**
 * Data Access Object (DAO) interface for interacting with question-related metadata in the database.
 */
@Dao
interface QuestionMetadataDao {

    /**
     * Adds a new question to the database.
     */
    @Insert
    suspend fun addQuestion(metadata: Question)

    /**
     * Removes a question from the database.
     */
    @Delete
    suspend fun removeQuestion(metadata: Question)

    /**
     * Updates an existing question in the database.
     */
    @Update
    suspend fun updateQuestion(metadata: Question)

    /**
     * Retrieves all questions for a specific topic from the database.
     */
    @Query("SELECT * from question_table where topicUid = :topicUid")
    suspend fun getAllQuestionsForTopic(topicUid: Int): List<Question>

    /**
     * Retrieves a question by its unique identifier (UID) from the database.
     */
    @Query("SELECT * from question_table where uid = :questionUid")
    suspend fun getQuestionByUid(questionUid: Long): Question?

    /**
     * Adds metadata for a question to the database.
     */
    @Insert
    suspend fun addMetadata(questionMetadata: QuestionMetadata)

    /**
     * Updates existing metadata for a question in the database.
     */
    @Update
    suspend fun updateMetadata(questionMetadata: QuestionMetadata)

    /**
     * Deletes metadata for a question from the database.
     */
    @Delete
    suspend fun deleteMetadata(questionMetadata: QuestionMetadata)

    /**
     * Retrieves metadata for a specific question and user from the database.
     */
    @Query("SELECT * from question_metadata_table where userUid = :userUid AND questionUid = :uid")
    suspend fun getMetadataForQuestion(uid: Long, userUid: String): QuestionMetadata?

    /**
     * Retrieves all metadata for questions associated with a specific topic and user from the database.
     */
    @Query(
        "SELECT question_metadata_table.*\n" +
                "FROM question_metadata_table\n" +
                "JOIN question_table ON question_metadata_table.questionUid = question_table.uid\n" +
                "WHERE question_table.topicUid = :topicUid AND userUid = :userUid "
    )
    suspend fun getAllMetadataForTopic(topicUid: Int, userUid: String): List<QuestionMetadata>

    /**
     * Retrieves the total count of questions in the database.
     */
    @Query(
        "SELECT COUNT(*) as row_count\n" +
                "FROM question_table;"
    )
    suspend fun getQuestionCount(): Int

    /**
     * Retrieves the total count of topics in the database.
     */
    @Query(
        "SELECT COUNT(uid)\n" +
                "FROM topic_metadata_table;"
    )
    suspend fun getTopicsCount(): Int

    /**
     * Adds a new topic to the database.
     */
    @Insert
    suspend fun addTopic(topic: TopicMetadata)

    /**
     * Retrieves the count of topics with a specific UID from the database.
     */
    @Query("SELECT COUNT(uid) FROM topic_metadata_table where uid = :uid")
    suspend fun topicCount(uid: Int): Int

    /**
     * Retrieves the count of metadata entries associated with a specific question from the database.
     */
    @Query("SELECT COUNT(uid) FROM question_metadata_table where questionUid = :uid")
    suspend fun metadataCountForQuestion(uid: Long): Int

    /**
     * Checks if metadata already exists for a specific question in the database.
     */
    suspend fun metadataAlreadyExists(questionMetadata: QuestionMetadata): Boolean {
        val count = metadataCountForQuestion(questionMetadata.questionUid)
        return count != 0
    }

    @Query("SELECT COUNT(uid) from question_table where uid = :uid")
    suspend fun getQuestionCount(uid: Long):Int
    suspend fun questionAlreadyExists(question: Question): Boolean {
        val count = getQuestionCount(question.uid)
        return count != 0
    }

    @Query("SELECT * from topic_metadata_table")
    suspend fun getAllTopics(): List<TopicMetadata>
    @Delete
   suspend fun removeQuestionMetadata(metadata: QuestionMetadata)


}
