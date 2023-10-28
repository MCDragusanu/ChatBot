package com.example.chatbot.account_manager

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthEmailException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException
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
        TODO("Not yet implemented")
    }

    override suspend fun sendEmailVerification(email: String): AccountResult {
        //https://firebase.google.com/docs/auth/android/manage-users#send_a_user_a_verification_email
        TODO("Not yet implemented")
    }

    override suspend fun changeEmail(oldEmail: String, password: String, newEmail: String): AccountResult {
        //in order to change any account credentials like password ,email or delete account,
        //first you have to authenticate the user with its credentials

        TODO("Not yet implemented")
    }

    override suspend fun changePassword(email: String, oldPassword: String, newPassword: String): AccountResult {
        //in order to change any account credentials like password ,email or delete account,
        //first you have to authenticate the user with its credentials
        TODO("Not yet implemented")
    }

    override suspend fun deleteAccount(email: String, password: String): AccountResult {
        //in order to change any account credentials like password ,email or delete account,
        //first you have to authenticate the user with its credentials
        TODO("Not yet implemented")
    }

    override suspend fun reauthUser(email: String, password: String): AccountResult {
        //To see how to reauth the user use this link https://firebase.google.com/docs/auth/android/manage-users#re-authenticate_a_user
        //use this method whenever you need to re-auth the user
        TODO("Not yet implemented")
    }

    override fun translateError(exception: Exception): AccountErrors {
       return  when(exception){
            is FirebaseAuthRecentLoginRequiredException->AccountErrors.ReauthRequired
            is FirebaseAuthInvalidUserException->AccountErrors.NoUserFound
            is FirebaseAuthEmailException->AccountErrors.InvalidEmail
            else -> AccountErrors.UnknownError(exception.localizedMessage?:"Unknown error has occurred")
        }
    }
}