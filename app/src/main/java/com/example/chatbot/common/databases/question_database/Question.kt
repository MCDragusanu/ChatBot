package com.example.chatbot.common.databases.question_database

class Question(val uid:Int  =0  , val topicUid:Int  =0 , val content:String ="", val hints:List<String> = emptyList() , val correctAnswer:String= "")