package com.example.chatbot.main.data.openai

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.http.Timeout
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import com.aallam.openai.client.OpenAIConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.minutes

/**
 * OpenAIClient is a client class for interacting with the OpenAI API for chat completion.
 *
 * @param apiKey The API key required for authentication with the OpenAI service.
 */
class OpenAIClient(apiKey: String) {

    // Configuration for OpenAI client
    private val config = OpenAIConfig(token = apiKey, timeout = Timeout(1.minutes))

    // OpenAI client instance
    private val client = OpenAI(config)

    /**
     * Sends a message to the OpenAI chat completion API and returns a Flow of [ChatCompletionState].
     *
     * @param chatCompletionRequest The request object containing information about the chat conversation.
     * @return A Flow emitting [ChatCompletionState] representing the different states of the chat message.
     */
    @OptIn(BetaOpenAI::class)
    fun sendMessage(chatCompletionRequest: ChatCompletionRequest): Flow<ChatCompletionState> = flow {

        // Emit the state when the message is sent
        emit(ChatCompletionState.Sent)

        // Attempt to interact with the OpenAI API
        val finalResult = try {
            // Perform the chat completion request
            val request = client.chatCompletion(chatCompletionRequest)

            // Emit the state when the response is received
            emit(ChatCompletionState.Received)

            // Extract the content of the message from the API response
            val message = request.choices.firstOrNull()?.message?.content
                ?: throw NullPointerException("No message received")

            // Emit the state with the responded message
            ChatCompletionState.Responeded(message)
        } catch (e: Exception) {
            // Emit the state when an error occurs
            ChatCompletionState.Error(e)
        }

        // Emit the final result, which can be a responded message or an error
        emit(finalResult)
    }

    companion object {
        // Model ID for the OpenAI GPT-3.5 Turbo model
        val model = ModelId("gpt-3.5-turbo")
    }
}
