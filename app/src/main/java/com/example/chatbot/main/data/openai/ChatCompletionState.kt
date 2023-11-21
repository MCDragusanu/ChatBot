package com.example.chatbot.main.data.openai

/**
 * Sealed class representing different states of a chat message.
 *
 * This sealed class defines four possible states:
 * - [Sent]: Represents the state when the chat message has been sent.
 * - [Received]: Represents the state when the chat message has been received.
 * - [Responded]: Represents the state when a response has been received with a specific content.
 * - [Error]: Represents the state when an error has occurred during the chat process, with an associated exception.
 *
 * This class also provides functions like [onSend], [onReceived], [onResponded], and [onError] to perform actions
 * based on the current state of the chat message.
 */
sealed class ChatCompletionState {

    /**
     * Represents the state when the chat message has been sent.
     */
    object Sent : ChatCompletionState()

    /**
     * Represents the state when the chat message has been received.
     */
    object Received : ChatCompletionState()

    /**
     * Represents the state when a response has been received with the specified content.
     *
     * @property content The content of the response.
     */
    class Responeded(val content: String) : ChatCompletionState()

    /**
     * Represents the state when an error has occurred during the chat process.
     *
     * @property exception The exception associated with the error.
     */
    class Error(val exception: Exception) : ChatCompletionState()

    /**
     * Executes the provided action if the current state is [Sent].
     *
     * @param action The action to be executed.
     * @return The current [ChatCompletionState] after handling the action.
     */
    fun onSend(action: () -> Unit): ChatCompletionState {
        if (this is Sent) action()
        return this
    }

    /**
     * Executes the provided action if the current state is [Received].
     *
     * @param action The action to be executed.
     * @return The current [ChatCompletionState] after handling the action.
     */
    fun onReceived(action: () -> Unit): ChatCompletionState {
        if (this is Received) action()
        return this
    }

    /**
     * Executes the provided action if the current state is [Responeded], passing the content of the response.
     *
     * @param action The action to be executed with the content of the response.
     * @return The current [ChatCompletionState] after handling the action.
     */
    fun onResponded(action: (String) -> Unit): ChatCompletionState {
        if (this is Responeded) action(content)
        return this
    }

    /**
     * Executes the provided action if the current state is [Error], passing the exception associated with the error.
     *
     * @param action The action to be executed with the exception.
     * @return The current [ChatCompletionState] after handling the action.
     */
    fun onError(action: (Exception) -> Unit): ChatCompletionState {
        if (this is Error) action(exception)
        return this
    }
}
