package com.example.chatbot.main.data.message_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.chatbot.main.data.message_database.model.ThreadMetadata

/**
 * Data Access Object (DAO) for managing thread metadata in the local storage database.
 */
@Dao
interface ThreadMetadataDao : MessageDao, InstructionDao {

    /**
     * Adds a new thread metadata to the local storage.
     *
     * @param threadMetadata The thread metadata to be added.
     */
    @Insert
    suspend fun addThread(threadMetadata: ThreadMetadata)

    /**
     * Updates an existing thread metadata in the local storage.
     *
     * @param threadMetadata The updated thread metadata.
     */
    @Update
    suspend fun updateThread(threadMetadata: ThreadMetadata)

    /**
     * Retrieves thread metadata based on its unique identifier.
     *
     * @param uid Unique identifier for the thread metadata.
     * @return ThreadMetadata object if found, otherwise null.
     */
    @Query("SELECT * from threads_table where uid = :uid")
    suspend fun getThreadByUid(uid: Long): ThreadMetadata?

    /**
     * Retrieves all threads associated with a specific session.
     *
     * @param sessionUid Unique identifier for the session.
     * @return List of thread metadata associated with the specified session.
     */
    @Query("SELECT * from threads_table where sessionUid = :sessionUid")
    suspend fun getAllThreadsForSession(sessionUid: Long): List<ThreadMetadata>

    /**
     * Deletes a thread and all associated messages and instruction from the local storage.
     *
     * @param threadMetadata The thread metadata to be deleted.
     */
    @Transaction
    suspend fun deleteThread(threadMetadata: ThreadMetadata) {
        clearMessagesForThread(threadMetadata.uid)
        deleteInstructionByUid(threadMetadata.instructionUid)
    }
}
