package com.example.chatbot.user_database

import androidx.room.Entity



data class User(val uid:String  = "",
           val email:String  = "",
           val firstName:String = "John",
           val lastName:String = "Doe",
           val isEmailVerified:Boolean = false ,
           val providerId:String = "Email",
           val dateOfCreation:String = "11.21.2023",
           val occupation:String = "Student",) {
}