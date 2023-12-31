package com.example.chatbot.main.data.database_messages.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.chatbot.main.data.database_messages.model.QuizMetadata

/**
 * Data Access Object (DAO) for managing thread metadata in the local storage database.
 */
@Dao
interface QuizMetadataDao : MessageDao, InstructionDao {

    /**
     * Adds a new thread metadata to the local storage.
     *
     * @param quizMetadata The thread metadata to be added.
     */
    @Insert
    suspend fun addThread(quizMetadata: QuizMetadata)

    /**
     * Updates an existing thread metadata in the local storage.
     *
     * @param quizMetadata The updated thread metadata.
     */
    @Update
    suspend fun updateThread(quizMetadata: QuizMetadata)

    /**
     * Retrieves thread metadata based on its unique identifier.
     *
     * @param uid Unique identifier for the thread metadata.
     * @return ThreadMetadata object if found, otherwise null.
     */
    @Query("SELECT * from quiz_table where uid = :uid")
    suspend fun getThreadByUid(uid: Long): QuizMetadata?

    /**
     * Retrieves all threads associated with a specific session.
     *
     * @param sessionUid Unique identifier for the session.
     * @return List of thread metadata associated with the specified session.
     */
    @Query("SELECT * from quiz_table where sessionUid = :sessionUid")
    suspend fun getAllThreadsForSession(sessionUid: Long): List<QuizMetadata>

    /**
     * Deletes a thread and all associated messages and instruction from the local storage.
     *
     * @param quizMetadata The thread metadata to be deleted.
     */
    @Transaction
    suspend fun deleteThread(quizMetadata: QuizMetadata) {
        clearMessagesForThread(quizMetadata.uid)
        deleteInstructionByUid(quizMetadata.instructionUid)
    }
}
