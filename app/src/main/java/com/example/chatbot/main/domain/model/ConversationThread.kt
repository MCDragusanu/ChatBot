package com.example.chatbot.main.domain.model

import com.example.chatbot.main.data.database_messages.model.Instruction
import com.example.chatbot.main.data.database_messages.model.Message
import com.example.chatbot.main.data.database_messages.model.QuizMetadata
import com.example.chatbot.main.data.database_questions.entity.Question


/**
 * Represents a conversation thread, including metadata, messages, question, and instruction.
 *
 * @property quizMetadata Metadata associated with the thread, such as unique identifier and related information.
 * @property messages List of messages in the thread.
 * @property question The question associated with the thread.
 * @property instruction The instruction associated with the thread.
 */
data class ConversationThread(
    val quizMetadata: QuizMetadata,
    val messages: List<Message>,
    val question: Question,
    val instruction: Instruction
)
