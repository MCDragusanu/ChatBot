package com.example.chatbot.main.domain.model

import com.example.chatbot.common.databases.question_database.Question
import com.example.chatbot.main.data.message_database.model.Instruction
import com.example.chatbot.main.data.message_database.model.Message
import com.example.chatbot.main.data.message_database.model.ThreadMetadata



/**
 * Represents a conversation thread, including metadata, messages, question, and instruction.
 *
 * @property threadMetadata Metadata associated with the thread, such as unique identifier and related information.
 * @property messages List of messages in the thread.
 * @property question The question associated with the thread.
 * @property instruction The instruction associated with the thread.
 */
data class ConversationThread(
    val threadMetadata: ThreadMetadata,
    val messages: List<Message>,
    val question: Question,
    val instruction: Instruction
)