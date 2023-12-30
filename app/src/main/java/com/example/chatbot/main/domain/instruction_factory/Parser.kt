package com.example.chatbot.main.domain.instruction_factory

interface Parser<T : GPTResponse> {

    /**
     * Parses a raw JSON string into an object of type [T].
     *
     * @param rawJSON The raw JSON string to be parsed.
     * @return An object of type [T] if parsing is successful, or null otherwise.
     */
    fun parseResponse(rawJSON: String): T?
}