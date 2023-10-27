package com.example.chatbot.on_board.data.auth

import com.example.chatbot.R

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
    class UnknownError(val errorMessage:String ) : AuthError(-1)

    /**
     * Represents an error due to an invalid email format with a specific error code.
     *
     * @param errorCode The error code indicating the invalid email format error.
     */
    object InvalidEmailFormat : AuthError(R.string.error_invalid_email_format)

    /**
     * Represents an error due to invalid credentials with a specific error code.
     *
     * @param errorCode The error code indicating the invalid credentials error.
     */
    object InvalidCredentials: AuthError(R.string.error_invalid_credentials)

    /**
     * Represents an error due to a user collision with a specific error code.
     *
     * @param errorCode The error code indicating the user collision error.
     */
    object UserCollision : AuthError(R.string.error_user_collision)

    /**
     * Represents an error indicating that the provided password is too weak with a specific error code.
     *
     * @param errorCode The error code indicating the password too weak error.
     */
    object PasswordTooWeak : AuthError(R.string.error_password_is_too_weak)

    object UserUidNotFound:AuthError(R.string.error_no_user_uid_found)
}
