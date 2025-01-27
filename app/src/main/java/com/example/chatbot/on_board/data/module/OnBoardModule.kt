package com.example.chatbot.on_board.data.module

import android.content.Context
import android.provider.ContactsContract.Data
import com.example.chatbot.common.services.account_manager.AccountManagerImpl
import com.example.chatbot.common.services.account_manager.AccountManager
import com.example.chatbot.common.services.account_manager.AccountManagerTestImpl
import com.example.chatbot.on_board.data.auth.AuthService
import com.example.chatbot.on_board.data.auth.AuthServiceImpl
import com.example.chatbot.on_board.data.auth.AuthServiceTestImpl
import com.example.chatbot.common.services.uid_generator.UIDGenerator
import com.example.chatbot.common.services.uid_generator.UIDGeneratorImpl
import com.example.chatbot.common.databases.user_database.UserRepository
import com.example.chatbot.common.databases.user_database.UserRepositoryImpl
import com.example.chatbot.main.data.database_questions.cloud.CloudDataSource
import com.example.chatbot.main.data.database_questions.cloud.FirebaseCloudDatabase
import com.example.chatbot.main.data.database_questions.local.QuestionMetadataDatabase
import com.example.chatbot.main.data.database_questions.local.QuestionRepository
import com.example.chatbot.main.data.database_questions.local.QuestionRepositoryImpl

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
class OnBoardModule private constructor( val userRepository: UserRepository, val dataSource: CloudDataSource.DataSource,val questionRepository: QuestionRepository , val cloudDataSource: CloudDataSource, val authService: AuthService, val accountManager : AccountManager, val uidGenerator: UIDGenerator) {

    companion object {
        private var instance: OnBoardModule? = null

        /**
         * Retrieves the singleton instance of the OnBoardModule.
         *
         * @param isInTestMode Whether the module should operate in test mode, using alternative implementations.
         * @return An instance of OnBoardModule configured based on the specified mode.
         */
        fun getModule(isInTestMode: Boolean, context: Context): OnBoardModule {
            return instance ?: run {

                //Creating a new instance of this module
                val newModule = OnBoardModule(
                    userRepository = UserRepositoryImpl(),
                    questionRepository = QuestionRepositoryImpl(QuestionMetadataDatabase.getInstance(context).dao),
                    cloudDataSource = FirebaseCloudDatabase(),
                    dataSource = CloudDataSource.DataSource.ProjectDatabase,
                    authService = if (isInTestMode) AuthServiceTestImpl() else AuthServiceImpl(),
                    accountManager = if(isInTestMode) AccountManagerTestImpl() else AccountManagerImpl(),
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
