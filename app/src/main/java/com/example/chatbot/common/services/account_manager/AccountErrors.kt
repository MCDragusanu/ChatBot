package com.example.chatbot.common.services.account_manager

import com.example.chatbot.R

/**
 * A sealed class representing specific account-related errors that may occur during operations.
 * It extends from Exception and encapsulates various error scenarios related to account management.
 *
 * @property errorCode The error code associated with the specific error scenario.
 */
sealed class AccountErrors(val errorCode: Int) : Exception() {

    /**
     * Represents an error for an invalid email format.
     */
    object InvalidEmail : AccountErrors(R.string.error_invalid_email_format)

    /**
     * Represents an error when no user is found.
     */
    object NoUserFound : AccountErrors(R.string.error_no_user_found)

    /**
     * Represents an error scenario where re-authentication is required.
     */
    object ReauthRequired : AccountErrors(R.string.error_auth_required)

    /**
     * Represents an unknown error scenario with a custom error message.
     *
     * @property errorMessage The custom error message associated with the unknown error.
     */
    class UnknownError(val errorMessage: String) : AccountErrors(-1)
}
