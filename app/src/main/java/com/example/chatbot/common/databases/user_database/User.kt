package com.example.chatbot.common.databases.user_database

import androidx.room.Entity


/**
 * Data class representing a user entity.
 *
 * @property uid Unique identifier for the user.
 * @property email Email address associated with the user.
 * @property firstName First name of the user. Default value is "John".
 * @property lastName Last name of the user. Default value is "Doe".
 * @property isEmailVerified Indicates whether the user's email has been verified. Default value is false.
 * @property providerId Provider ID indicating the method used for user authentication. Default value is "Email".
 * @property dateOfCreation Date when the user account was created. Default value is "11.21.2023".
 * @property occupation Occupation or role of the user. Default value is "Student".
 */
data class User(val uid:String  = "DEFAULT_USER",
           val email:String  = "",
           val firstName:String = "John",
           val lastName:String = "Doe",
           val isEmailVerified:Boolean = false ,
           val providerId:String = "Email",
           val dateOfCreation:String = "11.21.2023",
           val occupation:String = "Student",)