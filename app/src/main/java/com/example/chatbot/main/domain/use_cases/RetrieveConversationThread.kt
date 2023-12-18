package com.example.chatbot.main.domain.use_cases

import com.example.chatbot.main.data.database_messages.repository.ConversationRepository
import com.example.chatbot.main.domain.model.ConversationThread

interface RetrieveConversationThread {
    suspend fun execute(threadUid: Long, conversationRepository: ConversationRepository): Result<ConversationThread>
}