package com.example.chatbot.main.domain.use_cases

import android.util.Log
import com.example.chatbot.main.data.module.MainModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async

/**
 * Object responsible for synchronizing topics between the local database and the cloud data source.
 */
object SyncronizeTopics {

    /**
     * Executes the synchronization process for topics.
     *
     * @param mainModule MainModule providing access to repositories and data sources.
     * @param scope CoroutineScope for managing asynchronous tasks.
     */
    suspend fun execute(mainModule: MainModule, scope: CoroutineScope) {
        // Check if the local topics database is empty
        if (mainModule.questionRepository.noTopicsCached()) {
            // Retrieve topics from the cloud data source
            val topics = mainModule.cloudDataSource.getTopics(mainModule.source)

            // Handle the result of the cloud data source call
            topics.onSuccess {
                // Iterate through each retrieved topic
                it.onEach {
                    // Asynchronously add the topic to the local database
                    scope.async {
                        mainModule.questionRepository.addTopic(it)
                    }
                }
            }
        } else {
            // Log that topics are cached locally
            Log.d("Test", "Topics are cached locally")
        }
    }
}
