package com.example.chatbot

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.chatbot.main.data.question_metadata_database.cloud.CloudDataSource
import com.example.chatbot.main.data.question_metadata_database.cloud.FirebaseCloudDatabase
import com.example.chatbot.main.data.question_metadata_database.entity.TopicMetadata
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

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
    private val dataSource: CloudDataSource = FirebaseCloudDatabase()


}