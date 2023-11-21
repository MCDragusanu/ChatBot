package com.example.chatbot.common.services.account_manager

/**
 * A sealed class representing the result of an account-related operation, with two possible outcomes: success or failure.
 *
 * @param error An optional exception associated with the failure, which can be null for successful outcomes.
 */
sealed class AccountResult(val error: AccountErrors?) {

    /**
     * Represents a successful account operation.
     */
    class Success : AccountResult(null)

    /**
     * Represents a failed account operation with an associated exception.
     *
     * @param exception The exception that caused the failure.
     */
    class Failure(exception: AccountErrors) : AccountResult(exception)

    /**
     * Executes the specified action if the result represents a successful operation.
     *
     * @param action The action to execute on success.
     * @return The original result instance.
     */
    fun onSuccess(action: () -> Unit): AccountResult {
        if (this is Success) {
            action()
        }
        return this
    }

    /**
     * Executes the specified action if the result represents a failed operation.
     *
     * @param action The action to execute on failure.
     * @return The original result instance.
     */
    fun onFailure(action: (AccountErrors) -> Unit): AccountResult {
        if (this is Failure) {
            action(this.error ?: throw NullPointerException("Exception can't be null"))
        }
        return this
    }
}