package com.example.chatbot.on_board.data.auth

/**
 * A sealed class representing the result of an authentication operation.
 *
 * This class is designed to provide structured outcomes for authentication processes.
 * It can represent a successful completion with a user's unique identifier or a failure
 * with an associated [AuthError].
 *
 * @property userUid The user's unique identifier in case of a successful authentication, or null in case of failure.
 * @property error An [AuthError] in case of a failed authentication, or null in case of success.
 */
sealed class AuthResult(private val userUid: String?, private val error: AuthError?) {

    /**
     * Represents a successful authentication result with a user's unique identifier.
     *
     * @param userUid The user's unique identifier.
     */
    class Completed(userUid: String) : AuthResult(userUid, null)

    /**
     * Represents a failed authentication result with an associated [AuthError].
     *
     * @param error The [AuthError] indicating the reason for the failure.
     */
    class Failed(error: AuthError) : AuthResult(null, error)

    /**
     * Execute the specified action if the authentication was successful, passing the user's unique identifier.
     *
     * @param action A lambda function that takes a [String] parameter for the user's unique identifier.
     * @return This [AuthResult] instance.
     */
    fun onSuccess(action: (String) -> Unit): AuthResult {
        if (this is Completed) {
            action(this.userUid?:throw NullPointerException("User UID is null"))
        }
        return this
    }

    /**
     * Execute the specified action if the authentication was a failure, passing the associated [AuthError].
     *
     * @param action A lambda function that takes an [AuthError] parameter for error handling.
     * @return This [AuthResult] instance.
     */
    fun onFailure(action: (AuthError) -> Unit): AuthResult {
        if (this is Failed ) {
            action(this.error?: throw NullPointerException("Error is null"))
        }
        return this
    }
}
