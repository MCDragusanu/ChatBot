package com.example.chatbot.firestore

/**
 * An interface for retrieving API keys from a remote storage.
 */
interface APIKeyFetcher {
    /**
     * Retrieves an API key by its name.
     *
     * @param name The name of the API key to retrieve, e.g., "OPEN_API_KEY".
     * @return A Result object that encapsulates the result of the action. You can handle the result using
     *         [Result::onSuccess] and [Result::onFailure] to implement the desired logic.
     */
    suspend fun getAPIKey(name: String): Result<String>
}