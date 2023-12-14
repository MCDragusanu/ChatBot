package com.example.chatbot.common.services.api_key_fetcher

/**
 * An interface for retrieving API keys from a remote storage.
 */
interface APIKeyFetcher {
    /**
     * Retrieves an API key by its name.
     *
     * @param name The name of the API key to retrieve, e.g., "OPENAI_API_KEY", use only the constants defined inside the companion object
     *
     * @return A Result object that encapsulates the result of the action. You can handle the result using
     *         [Result::onSuccess] and [Result::onFailure] to implement the desired logic.
     */
    suspend fun getAPIKey( documentName:String,fieldName: String): Result<String>

    companion object{
        const val OPEN_AI_KEY_FIELD = "key"
        const val OPEN_AI_DOCUMENT_NAME = "open_ai_key"
        const val COLLECTION_NAME = "SECRET_KEYS"
     }
}