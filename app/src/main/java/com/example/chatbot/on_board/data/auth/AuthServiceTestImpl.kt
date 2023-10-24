package com.example.chatbot.on_board.data.auth

import com.example.chatbot.uid_generator.UIDGeneratorImpl
import kotlinx.coroutines.delay
import java.lang.Exception
/**
 * A test implementation of the [AuthService] abstract class.
 *
 * This class is intended for testing and may be used to simulate the behavior of the authentication service for testing
 * purposes. It implements the login, registration, and error translation methods defined in [AuthService] with TODO placeholders.
 * Developers should replace these placeholders with appropriate testing logic.
 */
class AuthServiceTestImpl:AuthService() {
    private val randomUIDGenerator = UIDGeneratorImpl()
    override suspend fun loginUser(email: String, password: String): AuthResult {
        delay(10000)
        return AuthResult.Completed(randomUIDGenerator.generateString())
    }

    override suspend fun registerUser(email: String, password: String): AuthResult {
        delay(10000)
        return AuthResult.Completed(randomUIDGenerator.generateString())
    }

    override fun translateError(exception: Exception): AuthError {
      return AuthError.UnknownError(-1)
    }
}