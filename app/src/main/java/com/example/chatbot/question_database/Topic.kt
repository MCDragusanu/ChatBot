package com.example.chatbot.question_database

class Topic(val uid : Int = 0, val label:String  = "", val keyWords:List<String> = emptyList() , val questionList:List<Question> = emptyList())