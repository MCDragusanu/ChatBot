package com.example.chatbot.on_board.data.auth

import java.lang.Exception

/**
 * An abstract class representing the authentication service for user login and registration.
 *
 * This class defines methods for attempting user login and registration, and it provides a way to translate exceptions into [AuthError] instances.
 */
abstract class AuthService {

    /**
     * Attempts to log in a user with the provided email and password.
     *
     * @param email The user's email address.
     * @param password The user's password.
     * @return An [AuthResult] representing the result of the login attempt, indicating success with a user's unique identifier
     *         or failure with an associated [AuthError].
     */
    abstract suspend fun loginUser(email: String, password: String): AuthResult

    /**
     * Attempts to register a new user with the provided email and password.
     *
     * @param email The email address to register.
     * @param password The password for the new user account.
     * @return An [AuthResult] representing the result of the registration attempt, indicating success with a user's unique identifier
     *         or failure with an associated [AuthError].
     */
    abstract suspend fun registerUser(email: String, password: String): AuthResult

    /**
     * Translates an exception into an [AuthError].
     *
     * This method is intended to handle exceptions that may occur during authentication operations and provide a meaningful
     * [AuthError] representation for error handling.
     *
     * @param exception The exception to translate into an [AuthError].
     * @return An [AuthError] representing the translated error.
     */
    protected abstract fun translateError(exception: Exception): AuthError
}

