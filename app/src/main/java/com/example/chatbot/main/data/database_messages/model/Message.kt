package com.example.chatbot.main.data.database_messages.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.properties.Delegates

/**
 * Represents a message entity in the local storage database.
 *
 * The instances of this class are stored in a table named "message_table" using Room Persistence Library.
 *
 * @property uid Unique identifier for the message. Each message has a distinct identifier.
 * @property threadUid Unique identifier for the thread to which the message belongs.
 * @property content The content of the message, representing the text or information.
 * @property sender The sender of the message. Can be one of the constants USER, BOT, or SYSTEM.
 *
 * @PrimaryKey Marks the 'uid' property as the primary key for the database.
 *
 * @Entity(tableName = "message_table")
 * Indicates that instances of this class will be stored in a table named "message_table" in the local database.
 */
@Entity(tableName = "message_table")
data class Message(

    val threadUid: Long,
    val content: String,
    val sender: Int
) {
   @PrimaryKey(autoGenerate = false)
    var uid : Long = System.currentTimeMillis()

    companion object {
        // Constants representing different message senders
        const val USER = 0
        const val BOT = 1
        const val SYSTEM = 2
    }

    /**
     * Checks if the message was sent by a user.
     *
     * @return true if the message was sent by a user, false otherwise.
     */
    fun isSentByUser() = this.sender == USER

    /**
     * Checks if the message was sent by the GPT (Bot).
     *
     * @return true if the message was sent by the GPT (Bot), false otherwise.
     */
    fun isSentByGPT() = this.sender == BOT

    /**
     * Checks if the message is a system message.
     *
     * @return true if the message is a system message, false otherwise.
     */
    fun isSystemMessage() = this.sender == SYSTEM

     fun asString(): String {
        return buildString {
            append("{\n\tcontent : ${content}\n\tsender : ${sender}\n}")
        }
    }
}
