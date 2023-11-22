package com.example.chatbot.main.domain.model

import com.example.chatbot.main.data.message_database.model.Instruction
import com.example.chatbot.main.data.message_database.model.SessionMetadata

/**
 * Represents a conversation session, including metadata and a list of associated threads.
 *
 * @property metadata Metadata associated with the session, such as unique identifier, user information, timestamp, and related topics.
 * @property threads List of conversation threads associated with the session.
 */
class Session(
    val metadata: SessionMetadata,
    val threads: List<ConversationThread>
)
