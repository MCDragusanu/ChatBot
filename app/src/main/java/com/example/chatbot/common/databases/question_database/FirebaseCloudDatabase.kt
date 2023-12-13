package com.example.chatbot.common.databases.question_database

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class FirebaseCloudDatabase: CloudDataSource {

    private val collectionRef = Firebase.firestore.collection("Question Database")
    override suspend fun addTopicsAndQuestions(topic: TopicMetadata): Result<Unit> {
        return try {
            val task = collectionRef.document("${topic.uid}").set(topic)
            task.await()

            if (task.isSuccessful)  Result.success(Unit)
            else  Result.failure(task.exception ?: Exception("Unknown error"))
        }catch (e:Exception){
            Result.failure(e)
        }
    }


    override suspend fun getTopic(topicUid: Int): Result<TopicMetadata> {
       return try {
            val task = collectionRef.document(topicUid.toString()).get()
            task.await()

            if (task.isSuccessful) {
                val _object = task.result.toObject(TopicMetadata::class.java)
                if (_object == null) {
                     Result.failure(Exception("Failed to convert document to Class Instance"))
                } else
                 Result.success(_object)
            }
             Result.failure(task.exception ?: Exception("Failed to retrieve document"))
        }catch (e:Exception) {
           Result.failure(e)
       }
    }
}