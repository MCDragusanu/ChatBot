package com.example.chatbot.common.services.uid_generator

/**
 * An interface for generating unique identifiers (UIDs) as long values and strings.
 */
interface UIDGenerator {
    /**
     * Generates a unique identifier as a long value.
     *
     * @return A unique identifier represented as a long value.
     */
    fun generateLong(): Long

    /**
     * Generates a unique identifier as a string.
     *
     * @return A unique identifier represented as a string.
     */
    fun generateString(): String
}