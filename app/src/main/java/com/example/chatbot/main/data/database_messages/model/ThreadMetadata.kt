package com.example.chatbot.main.data.database_messages.model

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Represents metadata for a conversation thread in the local storage database.
 *
 * The instances of this data class are stored in a table named "threads_table" using Room Persistence Library.
 *
 * @property uid Unique identifier for the thread metadata.
 * @property sessionUid Unique identifier for the session to which the thread belongs.
 * @property questionUid Unique identifier for the question associated with the thread.
 * @property instructionUid Unique identifier for the instruction associated with the thread.
 *
 * @PrimaryKey Marks the 'uid' property as the primary key for the database.
 *
 * @Entity(tableName = "threads_table")
 * Indicates that instances of this data class will be stored in a table named "threads_table" in the local database.
 */
@Entity(tableName = "threads_table")
data class ThreadMetadata(
    @PrimaryKey val uid: Long,
    val sessionUid: Long,
    val questionUid: Int,
    val instructionUid: Long
)
