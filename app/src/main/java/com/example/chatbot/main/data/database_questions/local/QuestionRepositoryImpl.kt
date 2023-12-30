package com.example.chatbot.main.data.database_questions.local

import android.util.Log
import com.example.chatbot.main.data.database_questions.entity.QuestionMetadata
import com.example.chatbot.main.data.database_questions.entity.Question
import com.example.chatbot.main.data.database_questions.entity.TopicMetadata
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class QuestionRepositoryImpl(private val questionMetadataDao: QuestionMetadataDao):QuestionRepository {
    override suspend fun addQuestionRow(question: Question) {
        if (!questionMetadataDao.questionAlreadyExists(question)) {
            questionMetadataDao.addQuestion(metadata = question)
        } else throw Exception("Primary key collision for question with pk = ${question.uid}")

    }

    override suspend fun addQuestionMetadata(questionMetadata: QuestionMetadata) {
        if (!questionMetadataDao.metadataAlreadyExists(questionMetadata)) {
            questionMetadataDao.addMetadata(questionMetadata)
        } else throw Exception("Primary key collision for questionMetadata with pk = ${questionMetadata.questionRowUid}")
    }

    override suspend fun removeQuestionMetadata(metadata: Question){
        questionMetadataDao.removeQuestion(metadata)
    }

    override suspend fun updateQuestionMetadata(metadata: Question) {
        questionMetadataDao.updateQuestion(metadata)
    }

    override suspend fun getAllMetadataForTopic(topicUid: Int , userUid: String): List<QuestionMetadata> {
        return questionMetadataDao.getAllMetadataForTopic(topicUid , userUid)
    }

    override suspend fun getMetadataByQuestionUid(uid: Int, userUid: String): QuestionMetadata? {
        return questionMetadataDao.getMetadataForQuestion(uid, userUid)
    }

    override suspend fun buildWeightMatrix(
        topics: List<Int>,
        userUid: String
    ): Array<Array<Double>> {
        try {
            val array = mutableListOf<Deferred<Array<Double>>>()
            val job = CoroutineScope(Dispatchers.IO).launch {
                topics.onEach { topicUid ->
                    val values = async {
                        questionMetadataDao.getAllMetadataForTopic(topicUid, userUid)
                            .map { it.weight }
                            .toTypedArray()
                    }
                    array += values
                }
            }
            job.join()
            val result = array.awaitAll()
            result.onEach {

                Log.d("Test", it.toString())
            }
            return result.toTypedArray()
        } catch (e: Exception) {
            e.printStackTrace()
            return emptyArray()
        }
    }

    override suspend fun noTopicsCached(): Boolean {
        return questionMetadataDao.getTopicsCount() == 0
    }

    override suspend fun noQuestionsCached(): Boolean {
        return questionMetadataDao.getQuestionCount() == 0
    }

    override suspend fun addTopic(topic: TopicMetadata) {
        if (questionMetadataDao.topicCount(topic.uid) == 0) {
            questionMetadataDao.addTopic(topic)
        }

    }

    override suspend fun getAllTopics(): List<TopicMetadata> {
        return questionMetadataDao.getAllTopics()
    }

    override suspend fun getQuestionByUid(questionUid: Int): Question? {
        return questionMetadataDao.getQuestionByUid(questionUid)
    }
}