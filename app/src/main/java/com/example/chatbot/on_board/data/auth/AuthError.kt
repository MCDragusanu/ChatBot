package com.example.chatbot.on_board.data.auth

/**
 * A sealed class representing different authentication error types, extending the Exception class.
 *
 * AuthError encapsulates various authentication-related error scenarios, each with a distinct error code.
 *
 * @param errorCode An integer code representing the specific error condition.
 */
sealed class AuthError(errorCode: Int) : Exception() {
    /**
     * Represents an unknown authentication error with a specific error code.
     *
     * @param errorCode The error code indicating the unknown error condition.
     */
    class UnknownError(errorCode: Int) : AuthError(errorCode)

    /**
     * Represents an error due to an invalid email format with a specific error code.
     *
     * @param errorCode The error code indicating the invalid email format error.
     */
    class InvalidEmailFormat(errorCode: Int) : AuthError(errorCode)

    /**
     * Represents an error due to invalid credentials with a specific error code.
     *
     * @param errorCode The error code indicating the invalid credentials error.
     */
    class InvalidCredentials(errorCode: Int) : AuthError(errorCode)

    /**
     * Represents an error due to a user collision with a specific error code.
     *
     * @param errorCode The error code indicating the user collision error.
     */
    class UserCollision(errorCode: Int) : AuthError(errorCode)

    /**
     * Represents an error indicating that the provided password is too weak with a specific error code.
     *
     * @param errorCode The error code indicating the password too weak error.
     */
    class PasswordTooWeak(errorCode: Int) : AuthError(errorCode)
}
