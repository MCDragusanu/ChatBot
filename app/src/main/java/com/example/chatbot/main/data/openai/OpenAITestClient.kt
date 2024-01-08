package com.example.chatbot.main.data.openai

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.ChatCompletionRequest
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OpenAITestClient : OpenAIClient {
    @OptIn(BetaOpenAI::class)
    override fun sendMessage(chatCompletionRequest: ChatCompletionRequest): Flow<ChatCompletionState> = flow {
        emit(ChatCompletionState.Sent)
        delay(100)
        emit(ChatCompletionState.Received)
        delay(750)
        emit(ChatCompletionState.Responeded("This is a test response"))
    }
}