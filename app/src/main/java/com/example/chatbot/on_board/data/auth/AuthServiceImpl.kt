package com.example.chatbot.on_board.data.auth

import java.lang.Exception

/**
 * A concrete implementation of the [AuthService] abstract class.
 *
 * This class provides the actual implementation of the authentication service, including methods for user login,
 * registration, and error translation.
 */
class AuthServiceImpl: AuthService() {
    override suspend fun loginUser(email: String, password: String): AuthResult {
        TODO("Not yet implemented")

    }

    override suspend fun registerUser(email: String, password: String): AuthResult {
        TODO("Not yet implemented")
    }

    override fun translateError(exception: Exception): AuthError {
        TODO("Not yet implemented")
    }
}