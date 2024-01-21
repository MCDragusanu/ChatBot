package com.example.chatbot.main.module_database.dao

import androidx.lifecycle.ViewModel
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.chatbot.main.module_database.model.Module
import com.example.chatbot.main.module_database.model.Question
import com.example.chatbot.main.module_database.model.Topic
import com.example.chatbot.main.module_database.model.UserAnswer

interface ModuleDao {

    @Insert
    suspend fun insertModule(module: Module)

    @Insert
    suspend fun insertQuestion(question: Question)

    @Insert
    suspend fun insertTopic(topic: Topic)

    @Insert
    suspend fun insertAnswer(userAnswer: UserAnswer)

    @Update
    suspend fun updateModule(module : Module)

    @Update
    suspend fun updateAnswer(answer: UserAnswer)


    @Update
    suspend fun updateQuestion(question: Question)

    @Update
    suspend fun updateTopic(question: Question)

    @Delete
    suspend fun deleteModule(module: Module)
    @Delete
    suspend fun deleteAnswer(answer: UserAnswer)
    @Delete
    suspend fun deleteQuestion(question: Question)

    @Delete
    suspend fun deleteTopic(topic: Topic)

    @Query("SELECT * from topic_table where moduleUid = :moduleUid")
    suspend fun getAllTopicsForModule(moduleUid:Int):List<Topic>

    @Query("SELECT * from question_table where topicUid = :topicUid")
    suspend fun getAllQuestionsForTopic(topicUid:Int) : List<Question.QuestionType>

    @Query("SELECT * from user_answer_table where sessionUid = :sessionUid AND questionUid = :questionUid AND userUid = :userUid")
    suspend fun getAnswerForQuestion(userUid:String , questionUid:Int , sessionUid:Int):UserAnswer?

    @Query("SELECT * from question_table where topicUid = :topicUid AND questionType == 0")
    suspend fun getAllSelfAssessmentQuestions(topicUid: Int) :List<Question>

}