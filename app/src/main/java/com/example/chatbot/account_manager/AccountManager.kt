package com.example.chatbot.account_manager

abstract class AccountManager {

    /**
     * Sends a password reset email to the provided email address.
     *
     * @param email The email address for which the password reset email will be sent.
     * @return An [AccountResult] indicating the result of the password reset operation.
     */
  abstract  suspend fun sendPasswordResetEmail(email: String): AccountResult

    /**
     * Sends an email verification request to the provided email address.
     *
     * @param email The email address to verify.
     * @return An [AccountResult] indicating the result of the email verification request.
     */
  abstract  suspend fun sendEmailVerification(email: String): AccountResult

    /**
     * Changes the email address associated with an account.
     *
     * @param oldEmail The current email address.
     * @param password The password for authentication.
     * @param newEmail The new email address to set.
     * @return An [AccountResult] indicating the result of the email change operation.
     */
   abstract suspend fun changeEmail(oldEmail: String, password: String, newEmail: String): AccountResult

    /**
     * Changes the password for an account.
     *
     * @param email The email address associated with the account.
     * @param oldPassword The current password.
     * @param newPassword The new password to set.
     * @return An [AccountResult] indicating the result of the password change operation.
     */
   abstract suspend fun changePassword(email: String, oldPassword: String, newPassword: String): AccountResult

    /**
     * Deletes an account associated with the provided email address and password.
     *
     * @param email The email address of the account to be deleted.
     * @param password The password for authentication.
     * @return An [AccountResult] indicating the result of the account deletion operation.
     */
  abstract  suspend fun deleteAccount(email: String, password: String): AccountResult

  protected abstract suspend fun reauthUser(email: String, password: String):AccountResult
}