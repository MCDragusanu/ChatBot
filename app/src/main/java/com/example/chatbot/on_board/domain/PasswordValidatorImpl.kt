package com.example.chatbot.on_board.domain

import android.util.Patterns

object PasswordValidatorImpl: PasswordValidator {
    override fun check(password: String): List<PasswordValidator.PasswordRequirements> {
        //val list = mutableListOf<PasswordValidator.PasswordRequirements> // creates a list that can be modified
        //loop through the PasswordValidator.PasswordRequirements.values()
        //use validation method th see if the password is correct
        //if the validation is true add it to the list
        //return the newly formed list

        val list = mutableListOf<PasswordValidator.PasswordRequirements>()
        for(requirement in PasswordValidator.PasswordRequirements.values())
        {
            if(requirement.validation(password) )
            {
                list.add(requirement)
            }
        }
        return list

    }
}