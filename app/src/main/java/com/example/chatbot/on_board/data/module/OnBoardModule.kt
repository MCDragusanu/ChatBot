package com.example.chatbot.on_board.data.module

import com.example.chatbot.on_board.data.auth.AuthService
import com.example.chatbot.on_board.data.auth.AuthServiceImpl
import com.example.chatbot.on_board.data.auth.AuthServiceTestImpl
import com.example.chatbot.uid_generator.UIDGenerator
import com.example.chatbot.uid_generator.UIDGeneratorImpl

/**
 * A singleton module for managing the configuration and dependencies related to onboarding and authentication.
 *
 * This module provides a single instance of itself, allowing the creation of an `OnBoardModule` with specific implementations
 * of the authentication service and user ID generator. It can be configured to operate in test mode by providing an alternative
 * test implementation of the authentication service.
 *
 * @property authService The authentication service used for user login and registration.
 * @property uidGenerator The user ID generator used for creating unique user identifiers.
 */
class OnBoardModule private constructor(private val authService: AuthService, private val uidGenerator: UIDGenerator) {

    companion object {
        private var instance: OnBoardModule? = null

        /**
         * Retrieves the singleton instance of the OnBoardModule.
         *
         * @param isInTestMode Whether the module should operate in test mode, using alternative implementations.
         * @return An instance of OnBoardModule configured based on the specified mode.
         */
        fun getModule(isInTestMode: Boolean): OnBoardModule {
            return instance ?: run {

                //Creating a new instance of this module
                val newModule = OnBoardModule(
                    authService = if (isInTestMode) AuthServiceTestImpl() else AuthServiceImpl(),
                    uidGenerator = UIDGeneratorImpl()
                )
                //saving the new instance in the instance variable
                instance = newModule

                //returning the new module created
                newModule
            }
        }
    }
}
