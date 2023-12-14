package com.example.chatbot.main.data.question_metadata_database.cloud

import com.example.chatbot.main.data.question_metadata_database.entity.QuestionMetadata
import com.example.chatbot.main.data.question_metadata_database.entity.TopicMetadata
import com.google.firebase.Firebase
import com.google.firebase.firestore.Filter
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class FirebaseCloudDatabase : CloudDataSource {

    // Firebase Firestore collections for topics and questions
    private val topicsCollection = Firebase.firestore.collection("MCARAMIHAI Topics")
    private val questionsCollection = Firebase.firestore.collection("MCARAMIHAI Qestions")

    // Add a new topic to the cloud database
    override suspend fun addTopic(topic: TopicMetadata,  source: CloudDataSource.DataSource): Result<Unit> {
        return try {
            // Set the topic metadata in the specified collection
            val task = Firebase.firestore.collection(source.topicCollection).document(topic.uid.toString())
                .set(topic)
            task.await()

            // Check if the operation was successful
            if (task.isSuccessful) Result.success(Unit)
            else throw task.exception
                ?: Exception("Unknown Error has occurred while adding topic to cloud database")

        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    // Add a list of questions to the cloud database
    override suspend fun addQuestions(
        questions: List<QuestionMetadata>,
        source: CloudDataSource.DataSource
    ): Result<Unit> {
        return try {
            // Use coroutines to asynchronously add each question to the specified collection
            val job = CoroutineScope(Dispatchers.IO).launch {
                questions.onEach {
                    async {
                        Firebase.firestore.collection(source.questionCollection)
                            .document(it.uid.toString()).set(it).addOnFailureListener {
                                throw it
                            }
                    }
                }
            }

            // Wait for all asynchronous jobs to complete
            job.invokeOnCompletion {
                if (it != null) throw it
            }

            job.join()

            Result.success(Unit)

        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    // Retrieve a topic by its UID from the cloud database
    override suspend fun getTopicByUid(uid: Int,  source: CloudDataSource.DataSource): Result<TopicMetadata> {
        return try {
            // Get the document by UID from the specified collection
            val task = Firebase.firestore.collection(source.topicCollection).document(uid.toString()).get()
            task.await()

            // Check if the retrieval was successful
            if (task.exception != null || !task.isSuccessful) {
                throw task.exception
                    ?: Exception("Unknown error occurred while retrieving topic with uid $uid")
            }

            // Convert the retrieved document to TopicMetadata
            val topic = task.result.toObject<TopicMetadata>()

            // Check for null and throw an exception if conversion failed
            if (topic == null) throw NullPointerException("Failed to convert query to POJO")

            Result.success(topic)

        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    // Retrieve questions associated with a specific topic from the cloud database
    override suspend fun getQuestionsForTopic(
        topic: TopicMetadata,
        source: CloudDataSource.DataSource
    ): Result<List<QuestionMetadata>> {
        return try {
            // Query documents in the question collection where topicUid matches
            val task = Firebase.firestore.collection(source.questionCollection)
                .where(Filter.equalTo("topicUid", topic.uid)).get()
            task.await()

            // Check if the retrieval was successful
            if (task.exception != null || !task.isSuccessful) {
                throw task.exception ?: Exception("Failed to retrieve questions")
            }

            // Use coroutines to asynchronously convert each document to QuestionMetadata
            val questions = mutableListOf<Deferred<QuestionMetadata>>()
            val job = CoroutineScope(Dispatchers.IO).launch {
                task.result.documents.onEach {
                    val fetchedQuestion = async {
                        return@async it.toObject<QuestionMetadata>()
                            ?: throw NullPointerException("Failed to convert document to POJO")
                    }
                    questions.add(fetchedQuestion)
                }
            }

            // Wait for all asynchronous jobs to complete
            job.join()

            // Check for any completion exception and throw it if present
            job.invokeOnCompletion {
                if (it != null) throw it
            }

            Result.success(questions.awaitAll())

        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}