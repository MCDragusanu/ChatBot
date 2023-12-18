package com.example.chatbot.main.data.question_metadata_database.cloud

import android.adservices.topics.Topic
import com.example.chatbot.main.data.question_metadata_database.entity.QuestionMetadata
import com.example.chatbot.main.data.question_metadata_database.entity.QuestionRow
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
        questions: List<QuestionRow>,
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

    override suspend fun getDatabaseContent(source: CloudDataSource.DataSource): Result<Pair<List<TopicMetadata>, List<QuestionRow>>> {
        return try {
            var topicsList = listOf<TopicMetadata>()
            var questionList = listOf<QuestionRow>()

            val job = CoroutineScope(Dispatchers.IO).launch {
                async {
                    val task = Firebase.firestore.collection(source.topicCollection).get()
                    task.await()

                    topicsList = task.result.documents.map {
                        it.toObject<TopicMetadata>()
                            ?: throw NullPointerException("Failed to retrieve topics")
                    }
                }
                async {
                    val task = Firebase.firestore.collection(source.questionCollection).get()
                    task.await()

                    questionList = task.result.documents.map {
                        it.toObject<QuestionRow>()
                            ?: throw NullPointerException("Failed to retrieve topics")
                    }
                }


            }
            // Wait for all asynchronous jobs to complete
            job.invokeOnCompletion {
                if (it != null) throw it
            }

            job.join()

            return Result.success(Pair(topicsList, questionList))

        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getTopics(source: CloudDataSource.DataSource): Result<List<TopicMetadata>> {
        return try {
            val job = Firebase.firestore.collection(source.topicCollection).get()
            job.await()

            if(job.isSuccessful){
                Result.success(job.result.documents.map { it.toObject<TopicMetadata>() ?: throw NullPointerException("Failed to convert topic document")})
            } else throw job.exception?: Exception("Unknown Errro has ocurred while retrieving topics")
        }catch (e:Exception){
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getQuestions(source: CloudDataSource.DataSource): Result<List<QuestionRow>> {
        return try {
            val job = Firebase.firestore.collection(source.questionCollection).get()
            job.await()

            if (job.isSuccessful) {
                Result.success(job.result.documents.map {
                    it.toObject<QuestionRow>()
                        ?: throw NullPointerException("Failed to convert topic document")
                })
            } else throw job.exception
                ?: Exception("Unknown Errro has ocurred while retrieving questions")
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getQuestionsForTopic(
        topic: TopicMetadata,
        source: CloudDataSource.DataSource
    ): Result<List<QuestionRow>> {
        return try {
            val task = Firebase.firestore.collection(source.questionCollection)
                .where(Filter.equalTo("topicUid", topic.uid)).get()
            task.await()

            if (task.isSuccessful) {
                Result.success(task.result.map {
                    it.toObject<QuestionRow>()
                        ?: throw NullPointerException("Failed to convert document to Question Row")
                })
            } else throw task.exception
                ?: Exception("Unknown error has occurred while retrieving queston for topics")
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }





}