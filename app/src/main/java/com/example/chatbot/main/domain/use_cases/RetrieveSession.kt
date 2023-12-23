package com.example.chatbot.main.domain.use_cases

import com.example.chatbot.main.data.database_messages.repository.ConversationRepository
import com.example.chatbot.main.data.database_questions.local.QuestionRepository
import com.example.chatbot.main.domain.model.Session

interface RetrieveSession {
    suspend fun execute(sessionUid: Long, repository: ConversationRepository,  questionRepository: QuestionRepository): Result<Session>
}