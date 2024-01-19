package com.example.chatbot.main.domain.use_cases

import android.util.Log
import com.example.chatbot.main.data.database_questions.cloud.CloudDataSource
import com.example.chatbot.main.data.module.MainModule
import com.example.chatbot.main.data.database_questions.entity.QuestionMetadata
import com.example.chatbot.main.data.database_questions.local.QuestionRepository
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
    suspend fun execute(cloudDataSource: CloudDataSource , userUid:String,dataSource: CloudDataSource.DataSource,questionRepository: QuestionRepository, scope: CoroutineScope) {
        // Check if the local question database is empty
        if (questionRepository.noQuestionsCached ()) {
            // Retrieve questions from the cloud database
            Log.d("Test" , "Beginning Retrieving Questions")
            val questions = cloudDataSource.getQuestions(dataSource)


            // Handle the result of the cloud data source call
            questions.onSuccess {
                Log.d("Test" , "Successfully retrieved ${it.size} questions")
                // Iterate through each retrieved question

                it.onEach { question ->
                    // Asynchronously check if there is metadata linked to the question
                    scope.async {
                        // Check if there is no metadata linked to the question for the current user
                        if (questionRepository.getMetadataByQuestionUid(
                                question.uid,
                                userUid
                            ) == null
                        ) {
                            // Create new metadata for the question
                            val metadata = QuestionMetadata(userUid =userUid, questionUid = question.uid)
                            // Insert the metadata into the metadata table
                            questionRepository.addQuestionMetadata(metadata)
                            Log.d("Test" , "Created Metadata")

                        }
                    }
                    // Asynchronously insert the new question into the question table
                    scope.async {
                        questionRepository.addQuestionRow(question)
                        Log.d("Test", "Row Inserted")
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
           if(questionRepository.noMetadataGenerated(userUid)){
               val questions = cloudDataSource.getQuestions(dataSource)


               // Handle the result of the cloud data source call
               questions.onSuccess {
                   Log.d("Test" , "Successfully retrieved ${it.size} questions")
                   // Iterate through each retrieved question

                   it.onEach { question ->
                       // Asynchronously check if there is metadata linked to the question
                       scope.async {
                           // Check if there is no metadata linked to the question for the current user
                           if (questionRepository.getMetadataByQuestionUid(
                                   question.uid,
                                   userUid
                               ) == null
                           ) {
                               // Create new metadata for the question
                               val metadata = QuestionMetadata(userUid =userUid, questionUid = question.uid)
                               // Insert the metadata into the metadata table
                               questionRepository.addQuestionMetadata(metadata)
                               Log.d("Test" , "Created Metadata")

                           }
                       }

                   }
               }.onFailure {
                   // Handle failure, print the stack trace, and return
                   it.printStackTrace()
                   return
               }
           }
        }
    }
}
