package com.example.chatbot.on_board.domain

/**
 * An interface for validating email addresses and providing a result indicating the validation outcome.
 */
interface EmailValidator {
    /**
     * Validates an email address.
     *
     * @param email The email address to be validated.
     * @return A [Result] indicating the validation outcome, which can be "Valid" for a valid email, "Empty" for an empty email,
     *         or "Invalid" for an invalid email.
     */
    fun check(email: String): Result

    /**
     * An enumeration representing the possible results of email validation.
     */
    enum class Result {
        /**
         * Represents a valid email address.
         */
        Valid,

        /**
         * Represents an empty email address.
         */
        Empty,

        /**
         * Represents an invalid email address.
         */
        Invalid
    }
}
