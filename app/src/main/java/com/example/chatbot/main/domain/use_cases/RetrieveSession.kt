package com.example.chatbot.main.domain.use_cases

import com.example.chatbot.main.data.message_database.repository.ConversationRepository
import com.example.chatbot.main.domain.model.Session

interface RetrieveSession {
    suspend fun execute(sessionUid: Long, repository: ConversationRepository): Result<Session>
}