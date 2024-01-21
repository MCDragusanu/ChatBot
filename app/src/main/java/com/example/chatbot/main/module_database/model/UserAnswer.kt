package com.example.chatbot.main.module_database.model

import androidx.room.Entity

@Entity("user_answer_table")
class UserAnswer(val uid : Long , val sessionUid:Long,val questionUid:Int, val userUid:String , val pickedAnswer : Int , val timeStamp:Long , )