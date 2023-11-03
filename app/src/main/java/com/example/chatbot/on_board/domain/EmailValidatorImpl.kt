package com.example.chatbot.on_board.domain

import android.util.Patterns

object EmailValidatorImpl:EmailValidator {
    override fun check(email: String): EmailValidator.Result {
        if (email.isBlank()) return EmailValidator.Result.Empty
        return if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) EmailValidator.Result.Valid
        else EmailValidator.Result.Invalid
    }
}