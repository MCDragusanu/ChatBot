package com.example.chatbot.on_board.domain

import PasswordValidator

object PasswordValidatorImpl:PasswordValidator {
    override fun check(password: String): List<PasswordValidator.PasswordRequirements> {
        TODO("Not yet implemented")
    }
}