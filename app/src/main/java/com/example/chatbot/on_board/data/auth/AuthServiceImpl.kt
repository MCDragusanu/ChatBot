package com.example.chatbot.on_board.data.auth

import com.google.firebase.auth.FirebaseAuth

/**
 * A concrete implementation of the [AuthService] abstract class.
 *
 * This class provides the actual implementation of the authentication service, including methods for user login,
 * registration, and error translation.
 */
class AuthServiceImpl: AuthService() {

    private val auth:FirebaseAuth = FirebaseAuth.getInstance()

    //see all the resources
    //https://firebase.google.com/docs/auth/android/password-auth
    // val task = auth.yourTask(args) ********** this starts the request and stored in 'task' variable
    // task.await()  *********** with this you say 'wait until the task is completed' // if you don't put this it will execute the remaining lines without waiting for the completion
    // if(task.isSuccessfully)
    //     val userUid = task.result.user?.uid **** get the userUid from the task's result
    //     if(userUid == null) return an AuthResult.Failure(UserUidNotFound) // handle the case when the userUid is null 99.999999999999999% of the time this won't happen but is nice to check
    //     else return an AuthResult.Completed(uid)
    // else
    //      val error = translateError(task.exception?: Exception()) // use the method defined in this class to handle the errors
    //      return AuthResult.Failure(error)
    //
    override suspend fun loginUser(email: String, password: String): AuthResult {

        TODO("Not Yet Implemented")
    }

    override suspend fun registerUser(email: String, password: String): AuthResult {
        TODO("Not yet implemented")
    }

    override fun translateError(exception: Exception): AuthError {
        // You will have to manually search on google what exception the auth.createUserWithEmailAndPassword and  auth.signInWithEmailAndPassword throw
        // and write a statement like this
        // put all the types you found inside this 'when' and try to match them with the Auth Error classes
        // for else case use AuthError.UnknownError
        // return when(exception){
        //    is FirebaseAuthInvalidCredentials -> AuthError.InvalidCredentials
        //    is .... -> ....
        //    .
        //    .
        //    .
        //    else -> AuthError.UnknownError(exception.message)
        // }
        TODO("Not yet implemented")
    }
}