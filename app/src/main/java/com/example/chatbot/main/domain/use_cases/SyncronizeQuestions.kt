package com.example.chatbot.main.domain.use_cases

import android.util.Log
import com.example.chatbot.main.data.module.MainModule
import com.example.chatbot.main.data.database_questions.entity.QuestionMetadata
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async

/**
 * Object responsible for synchronizing questions between the local database and the cloud data source.
 */
object SyncronizeQuestions {

    /**
     * Executes the synchronization process.
     *
     * @param module MainModule providing access to repositories and data sources.
     * @param scope CoroutineScope for managing asynchronous tasks.
     */
    suspend fun execute(module: MainModule, scope: CoroutineScope) {
        // Check if the local question database is empty
        if (module.questionRepository.noQuestionsCached()) {
            // Retrieve questions from the cloud database
            val questions = module.cloudDataSource.getQuestions(module.source)

            // Handle the result of the cloud data source call
            questions.onSuccess {
                // Iterate through each retrieved question
                it.onEach { question ->
                    // Asynchronously check if there is metadata linked to the question
                    scope.async {
                        // Check if there is no metadata linked to the question for the current user
                        if (module.questionRepository.getMetadataByQuestionUid(
                                question.uid,
                                module.currentUser.uid
                            ) == null
                        ) {
                            // Create new metadata for the question
                            val metadata = QuestionMetadata(userUid = module.currentUser.uid, questionUid = question.uid)
                            // Insert the metadata into the metadata table
                            module.questionRepository.addQuestionMetadata(metadata)
                        }
                    }
                    // Asynchronously insert the new question into the question table
                    scope.async {
                        module.questionRepository.addQuestionRow(question)
                    }
                }
            }.onFailure {
                // Handle failure, print the stack trace, and return
                it.printStackTrace()
                return
            }
        } else {
            // Log that questions are cached locally
            Log.d("Test", "Questions are cached locally")
        }
    }
}
