package com.example.chatbot.common.services.account_manager

import kotlinx.coroutines.delay
import java.lang.Exception

class AccountManagerTestImpl: AccountManager() {
    override suspend fun sendPasswordResetEmail(email: String): AccountResult {
        delay(1000)
        return AccountResult.Success()
    }

    override suspend fun sendEmailVerification(email: String): AccountResult {
        delay(1000)
        return AccountResult.Success()
    }

    override suspend fun changeEmail(oldEmail: String, password: String, newEmail: String): AccountResult {
        delay(1000)
        return AccountResult.Success()
    }

    override suspend fun changePassword(email: String, oldPassword: String, newPassword: String): AccountResult {
        delay(1000)
        return AccountResult.Success()
    }

    override suspend fun deleteAccount(email: String, password: String): AccountResult {
        delay(1000)
        return AccountResult.Success()
    }

    override suspend fun reauthUser(email: String, password: String): AccountResult {
        delay(1000)
        return AccountResult.Success()
    }

    override fun translateError(exception: Exception): AccountErrors {
        TODO("Not yet implemented")
    }
}