package com.example.chatbot

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.chatbot.question_database.CloudDataSource
import com.example.chatbot.question_database.FirebaseCloudDatabase
import com.example.chatbot.question_database.Question
import com.example.chatbot.question_database.Topic
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import kotlin.coroutines.coroutineContext

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.chatbot", appContext.packageName)
    }
}

@RunWith(AndroidJUnit4::class)
class TopicBuilder{
    private val dataSource:CloudDataSource = FirebaseCloudDatabase()

    @Test
    fun postTopic(){
        val questionList = listOf<Question>(Question(
            uid = 1,
            topicUid = 1,
            content = "What is the main concept of Object-Oriented Programming?",
            hints = listOf("Think about organizing code around objects and their interactions.")
        ),
            Question(
                uid = 2,
                topicUid = 1,
                content = "Explain the concept of a class in OOP.",
                hints = listOf("Consider how a class serves as a blueprint for objects.")
            ),
            Question(
                uid = 3,
                topicUid = 1,
                content = "How does inheritance work in OOP?",
                hints = listOf("Think about how a class can inherit properties and behaviors from another class.")
            ),
            Question(
                uid = 4,
                topicUid = 1,
                content = "What is polymorphism in OOP?",
                hints = listOf("Consider how objects of different classes can be treated as objects of a common base class.")
            ),
            Question(
                uid = 5,
                topicUid = 1,
                content = "Explain the concept of encapsulation.",
                hints = listOf("Think about bundling data and methods that operate on the data within a class.")
            ))
        //De fiecare data aveti grija sa incrementati uid ul
        val topic = Topic(
            uid =1,
            label = "Object-Oriented Programming",
            keyWords = listOf("OOP", "Object-Oriented Programming", "Classes", "Inheritance", "Polymorphism", "Encapsulation", "Abstraction"),
            questionList = questionList
        )
        CoroutineScope(Dispatchers.IO).launch {
            dataSource.addTopicsAndQuestions(topic)
        }



    }
}