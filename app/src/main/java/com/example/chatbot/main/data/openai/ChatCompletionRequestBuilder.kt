package com.example.chatbot.main.data.openai

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.chat.chatCompletionRequest
import com.example.chatbot.main.data.message_database.model.Message

/**
 * Builder class for creating a [ChatCompletionRequest] based on conversation history and the current user message.
 */
class ChatCompletionRequestBuilder {

   /**
    * Builds a [ChatCompletionRequest] using the provided conversation history and the current user message.
    *
    * @param conversationHistory List of [Message] objects representing the conversation history.
    * @param currentUserMessage The current user's message.
    * @return A [ChatCompletionRequest] object configured based on the provided conversation history and user message.
    */
   @OptIn(BetaOpenAI::class)
   fun build(
      conversationHistory: List<Message>,
      currentUserMessage: Message
   ): ChatCompletionRequest {
      // Map conversation history and append the current user's message to create a list of ChatMessage objects
      val content = conversationHistory.map {
         ChatMessage(
            role = when {
               it.isSystemMessage() -> ChatRole.System
               it.isSentByUser() -> ChatRole.User
               else -> ChatRole.Assistant
            },
            content = it.content
         )
      } + ChatMessage(role = ChatRole.User, content = currentUserMessage.content)

      // Create and return the ChatCompletionRequest using the configured messages and the GPT-3.5 Turbo model
      return chatCompletionRequest {
         messages = content
         model = OpenAIClient.model
      }
   }
}