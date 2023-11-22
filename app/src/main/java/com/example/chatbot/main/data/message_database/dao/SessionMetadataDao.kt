package com.example.chatbot.main.data.message_database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.chatbot.main.data.message_database.model.SessionMetadata
import com.example.chatbot.main.domain.model.Session

/**
 * Data Access Object (DAO) for managing session metadata in the local storage database.
 */
@Dao
interface SessionMetadataDao : ThreadMetadataDao {

    /**
     * Adds a new session metadata to the local storage.
     *
     * @param metadata The session metadata to be added.
     */
    @Insert
    suspend fun addSessionMetadata(metadata: SessionMetadata)

    /**
     * Deletes an existing session metadata from the local storage.
     *
     * @param metadata The session metadata to be deleted.
     */
    @Delete
    suspend fun deleteMetadata(metadata: SessionMetadata)

    /**
     * Updates an existing session metadata in the local storage.
     *
     * @param metadata The updated session metadata.
     */
    @Update
    suspend fun updateMetadata(metadata: SessionMetadata)

    /**
     * Retrieves session metadata based on its unique identifier.
     *
     * @param metadataUid Unique identifier for the session metadata.
     * @return SessionMetadata object if found, otherwise null.
     */
    @Query("SELECT * from session_table where uid = :metadataUid")
    suspend fun getMetadataByUid(metadataUid: Long): SessionMetadata?

    /**
     * Retrieves sessions associated with a specific user.
     *
     * @param userUid Unique identifier for the user.
     * @return List of session metadata associated with the specified user.
     */
    @Query("SELECT * from session_table where userUid = :userUid")
    suspend fun getSessionsForUser(userUid: String): List<SessionMetadata>

    /**
     * Deletes a session and all associated threads from the local storage.
     *
     * @param session The session metadata to be deleted.
     */
    @Transaction
    suspend fun deleteSession(session: SessionMetadata) {
        getAllThreadsForSession(session.uid).onEach {
            deleteThread(it)
        }
    }
}
