package com.example.chatbot.main.data.module

import android.app.Application
import android.util.Log
import com.example.chatbot.common.services.account_manager.AccountManager
import com.example.chatbot.common.services.account_manager.AccountManagerImpl
import com.example.chatbot.common.services.account_manager.AccountManagerTestImpl
import com.example.chatbot.common.services.api_key_fetcher.APIKeyFetcher
import com.example.chatbot.common.services.api_key_fetcher.FirestoreKeyFetcher
import com.example.chatbot.common.services.network_observer.NetworkObserver
import com.example.chatbot.common.services.network_observer.NetworkObserverImpl
import com.example.chatbot.common.services.uid_generator.UIDGenerator
import com.example.chatbot.common.services.uid_generator.UIDGeneratorImpl
import com.example.chatbot.main.data.message_database.database.ConversationDatabase
import com.example.chatbot.main.data.openai.OpenAIClient
import com.example.chatbot.main.data.question_metadata_database.local.QuestionMetadataDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainModule private constructor(val keyFetcher: APIKeyFetcher,
                                     val accountManager:AccountManager,
                                     val networkObserver: NetworkObserver ,
                                     val uidGenerator: UIDGenerator ,
                                     val conversationDatabase: ConversationDatabase,
                                     val questionMetadataDatabase: QuestionMetadataDatabase


    ) {
    var openAIClient: OpenAIClient? = null

    init {
        CoroutineScope(Dispatchers.IO).launch {
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
            openAIClient = OpenAIClient(apiKey)
        }
    }

    companion object {
        private var instance: MainModule? = null

        fun getInstance(inTestMode: Boolean, application: Application): MainModule {
            return instance ?: MainModule(
                keyFetcher = FirestoreKeyFetcher(),
                accountManager = if (!inTestMode) AccountManagerImpl() else AccountManagerTestImpl(),
                networkObserver = NetworkObserverImpl(application.applicationContext),
                uidGenerator = UIDGeneratorImpl(),
                questionMetadataDatabase = QuestionMetadataDatabase.getInstance(application.applicationContext),
                conversationDatabase = ConversationDatabase.getInstance(application.applicationContext)
            )
        }
    }
}