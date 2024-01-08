package com.example.chatbot.main.data.openai

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.ChatCompletionRequest
import kotlinx.coroutines.flow.Flow

interface OpenAIClient {
    @OptIn(BetaOpenAI::class)
    fun sendMessage(chatCompletionRequest: ChatCompletionRequest): Flow<ChatCompletionState>
}