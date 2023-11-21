package com.example.chatbot.user_database

interface UserRepository {


    suspend fun addUser(user: User):Result<Unit>

    suspend fun deleteUser(user: User):Result<Unit>

    suspend fun updateUser(user: User):Result<Unit>

    suspend fun getUserByUid(userUid:String):Result<User?>


}