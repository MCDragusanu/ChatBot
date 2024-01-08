package com.example.chatbot.main.data.module

import android.app.Application
import android.util.Log
import com.example.chatbot.common.databases.user_database.User
import com.example.chatbot.common.services.account_manager.AccountManager
import com.example.chatbot.common.services.account_manager.AccountManagerImpl
import com.example.chatbot.common.services.account_manager.AccountManagerTestImpl
import com.example.chatbot.common.services.api_key_fetcher.APIKeyFetcher
import com.example.chatbot.common.services.api_key_fetcher.FirestoreKeyFetcher
import com.example.chatbot.common.services.network_observer.NetworkObserver
import com.example.chatbot.common.services.network_observer.NetworkObserverImpl
import com.example.chatbot.common.services.uid_generator.UIDGenerator
import com.example.chatbot.common.services.uid_generator.UIDGeneratorImpl
import com.example.chatbot.main.data.database_messages.database.ConversationDatabase
import com.example.chatbot.main.data.database_messages.repository.ConversationRepository
import com.example.chatbot.main.data.database_messages.repository.ConversationRepositoryImpl
import com.example.chatbot.main.data.openai.OpenAIClientImpl
import com.example.chatbot.main.data.database_questions.cloud.CloudDataSource
import com.example.chatbot.main.data.database_questions.cloud.FirebaseCloudDatabase
import com.example.chatbot.main.data.database_questions.local.QuestionMetadataDatabase
import com.example.chatbot.main.data.database_questions.local.QuestionRepository
import com.example.chatbot.main.data.database_questions.local.QuestionRepositoryImpl
import com.example.chatbot.main.data.openai.OpenAIClient
import com.example.chatbot.main.data.openai.OpenAITestClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainModule private constructor(isInTestMode:Boolean,
                                     val keyFetcher: APIKeyFetcher,
                                     val accountManager:AccountManager,
                                     val networkObserver: NetworkObserver,
                                     val uidGenerator: UIDGenerator,
                                     val source:CloudDataSource.DataSource,
                                     val conversationDatabase: ConversationDatabase,
                                     val conversationRepository:ConversationRepository,
                                     val questionMetadataDatabase: QuestionMetadataDatabase,
                                     val questionRepository:QuestionRepository,
                                     val cloudDataSource: CloudDataSource,
                                     val currentUser:User = User()


    ) {
    var openAIClient: OpenAIClient? = null

    init {
      /* if(!isInTestMode)*/ CoroutineScope(Dispatchers.IO).launch {
            val apiKey = keyFetcher.getAPIKey(
                documentName = APIKeyFetcher.OPEN_AI_DOCUMENT_NAME,
                fieldName = APIKeyFetcher.OPEN_AI_KEY_FIELD
            ).onFailure {
                Log.d("Test", "Failed to retrieve api key")
                it.printStackTrace()
                throw it
            }.onSuccess {
                Log.d("Test", "API Key retrieved!")
            }.getOrNull() ?: "DEFAULT API KEY"
            openAIClient = OpenAIClientImpl(apiKey)
        }
       // else openAIClient = OpenAITestClient()
    }

    companion object {
        private var instance: MainModule? = null

        fun getInstance(
            inTestMode: Boolean,
            application: Application,
            currentUser: User,
            dataSource: CloudDataSource.DataSource
        ): MainModule {
            return instance ?: MainModule(
                isInTestMode = inTestMode,
                keyFetcher = FirestoreKeyFetcher(),
                accountManager = if (!inTestMode) AccountManagerImpl() else AccountManagerTestImpl(),
                networkObserver = NetworkObserverImpl(application.applicationContext),
                uidGenerator = UIDGeneratorImpl(),
                source = dataSource,
                questionMetadataDatabase = QuestionMetadataDatabase.getInstance(application.applicationContext),
                conversationDatabase = ConversationDatabase.getInstance(application.applicationContext),
                questionRepository = QuestionRepositoryImpl(
                    questionMetadataDao = QuestionMetadataDatabase.getInstance(
                        application.applicationContext
                    ).dao
                ),
                conversationRepository = ConversationRepositoryImpl(
                    ConversationDatabase.getInstance(
                        application.applicationContext
                    ).sessionMetadataDao
                ),
                cloudDataSource = FirebaseCloudDatabase(),
                currentUser = currentUser
            )
        }
    }
}