package com.example.chatbot.main.domain.use_cases

import android.util.Log
import com.example.chatbot.main.data.database_questions.cloud.CloudDataSource
import com.example.chatbot.main.data.database_questions.local.QuestionRepository
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
    suspend fun execute(cloudDataSource: CloudDataSource,  dataSource: CloudDataSource.DataSource, questionRepository: QuestionRepository, scope: CoroutineScope) {
        // Check if the local topics database is empty
        if (questionRepository.noTopicsCached()) {
            // Retrieve topics from the cloud data source
            Log.d("Test" , "Beginning Retrieving Topics")
            val topics = cloudDataSource.getTopics(dataSource)

            // Handle the result of the cloud data source call
            topics.onSuccess {
                // Iterate through each retrieved topic
                it.onEach {
                    // Asynchronously add the topic to the local database
                    scope.async {
                        questionRepository.addTopic(it)
                    }
                }
            }.onFailure { it.printStackTrace() }
        } else {
            // Log that topics are cached locally
            Log.d("Test", "Topics are cached locally")
        }
    }
}
