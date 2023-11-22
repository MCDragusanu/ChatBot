package com.example.chatbot.main.data.message_database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.chatbot.main.data.message_database.model.Message

/**
 * Data Access Object (DAO) for managing messages in the local storage database.
 */
@Dao
interface MessageDao {

    /**
     * Adds a new message to the local storage.
     *
     * @param message The message to be added.
     */
    @Insert
    suspend fun addMessage(message: Message)

    /**
     * Deletes an existing message from the local storage.
     *
     * @param message The message to be deleted.
     */
    @Delete
    suspend fun deleteMessage(message: Message)

    /**
     * Updates an existing message in the local storage.
     *
     * @param message The updated message.
     */
    @Update
    suspend fun updateMessage(message: Message)

    /**
     * Retrieves messages associated with a specific thread.
     *
     * @param threadUid Unique identifier for the thread.
     * @return List of messages in the specified thread.
     */
    @Query("SELECT * from message_table where threadUid = :threadUid")
    suspend fun getMessagesForThread(threadUid: Long): List<Message>

    /**
     * Clears all messages associated with a specific thread from the local storage.
     *
     * @param threadUid Unique identifier for the thread.
     */
    @Query("DELETE from message_table where threadUid = :threadUid")
    suspend fun clearMessagesForThread(threadUid: Long)
}

