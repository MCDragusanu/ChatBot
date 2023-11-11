package com.example.chatbot.on_board.data.auth

import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthEmailException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import io.ktor.util.*
import kotlinx.coroutines.tasks.await

/**
 * A concrete implementation of the [AuthService] abstract class.
 *
 * This class provides the actual implementation of the authentication service, including methods for user login,
 * registration, and error translation.
 */
class AuthServiceImpl: AuthService() {

    private val auth:FirebaseAuth = FirebaseAuth.getInstance()
    override suspend fun loginUser(email: String, password: String): AuthResult {

        return try {
            val task = auth.signInWithEmailAndPassword(email, password)
            task.await()

            if (task.isSuccessful) {
                 AuthResult.Completed(task.result.user?.uid ?: throw AuthError.UserUidNotFound)
            } else {
                val error = translateError(task.exception ?: Exception("Unknown Exception"))
                 AuthResult.Failed(error)
            }
        }catch (e:Exception){
            e.printStackTrace()
            AuthResult.Failed(translateError(e))
        }
    }

    override suspend fun registerUser(email: String, password: String): AuthResult {

        return try {
            val task = auth.createUserWithEmailAndPassword(email, password)
            task.await()

            if (task.isSuccessful) {
                AuthResult.Completed(task.result.user?.uid ?: throw AuthError.UserUidNotFound)
            } else {
                val error = translateError(task.exception ?: Exception("Unknown Exception"))
                AuthResult.Failed(error)
            }
        }catch (e:Exception){
            e.printStackTrace()
            AuthResult.Failed(translateError(e))
        }
    }


    override fun translateError(exception: Exception): AuthError {
      return when(exception){
          is FirebaseAuthInvalidCredentialsException->AuthError.InvalidCredentials
          is FirebaseAuthEmailException->AuthError.InvalidEmailFormat
          is FirebaseAuthInvalidUserException->AuthError.UserUidNotFound
          else -> AuthError.UnknownError(exception.message?:"Unknown Error")
      }
    }
}