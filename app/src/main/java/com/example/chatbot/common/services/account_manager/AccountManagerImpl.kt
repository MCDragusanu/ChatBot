package com.example.chatbot.common.services.account_manager

import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthEmailException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class AccountManagerImpl: AccountManager() {

    // look here to see all the resources
    // https://firebase.google.com/docs/auth/android/manage-users
    // you don't have to use exampleTask().addOnCompleteListener(lambda).addOnFailureListener(lambda)
    // you do like this
    // val task = auth.exampleTask(args) // this starts the request and stored in 'task' variable
    // task.await()  // with this you say 'wait until the task is completed' // if you don't put this it will execute the remaining lines without waiting for the completion
    // if(task.isSuccessful) return AccountResult.Success()
    // else return AccountResult.Failure(task.exception?:Exception("Unknown Error has occurred)) to handle error case // leftArg ?: rightArg is short for (if(leftArg == null) do rightArg

    private val auth:FirebaseAuth = FirebaseAuth.getInstance() // this object contains the methods needed to perform the actions
    override suspend fun sendPasswordResetEmail(email: String): AccountResult {
        //https://firebase.google.com/docs/auth/android/manage-users#send_a_password_reset_email
        return try
        {
            val task = auth.sendPasswordResetEmail(email)
            task.await()
            if (task.isSuccessful)
                AccountResult.Success()
            else {
                val translatedError = translateError(task.exception?:Exception())
                AccountResult.Failure(translatedError)
            }
        }catch(e:Exception){
            val translatedError = translateError(e)
            AccountResult.Failure(translatedError)
        }
    }

    override suspend fun sendEmailVerification(email: String): AccountResult {
        return try {
            val user = auth.currentUser
            if (user == null) {
                return AccountResult.Failure(AccountErrors.NoUserFound)
            }
            val task = user.sendEmailVerification()
            task.await()
            if (task.isSuccessful) {
                AccountResult.Success()
            } else {
                val translatedError = translateError(task.exception?:Exception())
                AccountResult.Failure(translatedError)
            }
        }catch(e:Exception) {
                val translatedError = translateError(e)
            AccountResult.Failure(translatedError)
            }
        }

    override suspend fun changeEmail(oldEmail: String, password: String, newEmail: String): AccountResult {

        val user = auth.currentUser
        if (user == null) {
            return AccountResult.Failure(AccountErrors.NoUserFound)
        }
        val result = reauthUser(oldEmail, password)
        if (result == AccountResult.Success()) {
            return try {
                val task = user.updateEmail(newEmail)
                task.await()
                if (task.isSuccessful) {
                    AccountResult.Success()
                } else {
                    val translatedError = translateError(task.exception ?: Exception())
                    AccountResult.Failure(translatedError)
                }
            }catch(e:Exception) {
                val translatedError = translateError(e)
                AccountResult.Failure(translatedError)
            }
        }
        else return AccountResult.Failure(AccountErrors.ReauthRequired)
    }

    override suspend fun changePassword(email: String, oldPassword: String, newPassword: String): AccountResult {

        val user = auth.currentUser
        if (user == null) {
            return AccountResult.Failure(AccountErrors.NoUserFound)
        }
        val result = reauthUser(email, oldPassword)
        if (result == AccountResult.Success()) {
            return try {
                val task = user.updatePassword(newPassword)
                task.await()
                if (task.isSuccessful) {
                    AccountResult.Success()
                } else {
                    val translatedError = translateError(task.exception ?: Exception())
                    AccountResult.Failure(translatedError)
                }
            }catch(e:Exception) {
                val translatedError = translateError(e)
                AccountResult.Failure(translatedError)
            }
        }
        else return AccountResult.Failure(AccountErrors.ReauthRequired)
    }

    override suspend fun deleteAccount(email: String, password: String): AccountResult {
        val user = auth.currentUser
        if (user == null) {
            return AccountResult.Failure(AccountErrors.NoUserFound)
        }
        val result = reauthUser(email, password)
        if (result == AccountResult.Success()) {
            return try {
                val task = user.delete()
                task.await()
                if (task.isSuccessful) {
                    AccountResult.Success()
                }
                else {
                    val translatedError = translateError(task.exception ?: Exception())
                    AccountResult.Failure(translatedError)
                }
            }catch(e:Exception) {
                val translatedError = translateError(e)
                AccountResult.Failure(translatedError)
            }
        }
        else return AccountResult.Failure(AccountErrors.ReauthRequired)
    }

    override suspend fun reauthUser(email: String, password: String): AccountResult {
        val user = auth.currentUser
        if (user == null) {
            return AccountResult.Failure(AccountErrors.NoUserFound)
        }
        val credential = EmailAuthProvider.getCredential(email, password)
        return try {
            val task = user.reauthenticate(credential)
            task.await()
            if (task.isSuccessful)
                AccountResult.Success()
            else {
                val translatedError = translateError(task.exception ?: Exception())
                AccountResult.Failure(translatedError)
            }
        }catch(e:Exception) {
            val translatedError = translateError(e)
            AccountResult.Failure(translatedError)
        }
    }

    override fun translateError(exception: Exception): AccountErrors {
       return  when(exception){
            is FirebaseAuthRecentLoginRequiredException-> AccountErrors.ReauthRequired
            is FirebaseAuthInvalidUserException-> AccountErrors.NoUserFound
            is FirebaseAuthEmailException-> AccountErrors.InvalidEmail
            else -> AccountErrors.UnknownError(
                exception.localizedMessage ?: "Unknown error has occurred"
            )
        }
    }
}