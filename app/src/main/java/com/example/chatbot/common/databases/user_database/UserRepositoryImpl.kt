package com.example.chatbot.common.databases.user_database

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class UserRepositoryImpl: UserRepository {

    private val userCollection = Firebase.firestore.collection("User Collection")

    override suspend fun addUser(user: User): Result<Unit> {
        return try {
            val task = userCollection.document(user.uid).set(user)
            task.await()

            if (task.isSuccessful) Result.success(Unit)
            else throw task.exception
                ?: Exception("Unknown Error has occurred when posting a new user account")
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deleteUser(user: User): Result<Unit> {
        return try {
            val task = userCollection.document(user.uid).delete()
            task.await()

            if (task.isSuccessful) Result.success(Unit)
            else throw task.exception
                ?: Exception("Unknown Error has occurred when deleting a user account")
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateUser(user: User): Result<Unit> {
        return try {
            val task = userCollection.document(user.uid).delete()
            task.await()

            if (task.isSuccessful) Result.success(Unit)
            else throw task.exception
                ?: Exception("Unknown Error has occurred when updating a user account")
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getUserByUid(userUid: String): Result<User?> {
        return try {
            val task = userCollection.document(userUid).get()
            task.await()

            if (task.isSuccessful) {
                val obj = task.result.toObject(User::class.java)
                    ?: throw NullPointerException("Failed to convert document to user")
                Result.success(obj)
            }
            else throw task.exception
                ?: Exception("Unknown Error has occurred when retrieving a user account")
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}