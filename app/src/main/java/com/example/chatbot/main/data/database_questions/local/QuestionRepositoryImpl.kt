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
        } else throw Exception("Primary key collision for questionMetadata with pk = ${questionMetadata.questionUid}")
    }

    override suspend fun removeQuestionMetadata(metadata: QuestionMetadata){
        questionMetadataDao.removeQuestionMetadata(metadata)
    }

    override suspend fun updateQuestionMetadata(metadata: QuestionMetadata) {
        Log.d("Grade" , "Updating metadata with uid = ${metadata.uid} for question with uid = ${metadata.questionUid} , status = ${metadata.status} and content = ${getQuestionByUid(metadata.questionUid)}, ")
        questionMetadataDao.updateMetadata(metadata)
    }

    override suspend fun getAllMetadataForTopic(topicUid: Int , userUid: String): List<QuestionMetadata> {
        return questionMetadataDao.getAllMetadataForTopic(topicUid , userUid)
    }

    override suspend fun getMetadataByQuestionUid(questionUid: Long, userUid: String): QuestionMetadata? {
        return questionMetadataDao.getMetadataForQuestion(questionUid, userUid)
    }

    override suspend fun buildWeightMatrix(

        userUid: String
    ): Array<Array<Pair<Double , Long>>> {
        try {
            val array = mutableListOf<Deferred<Array<Pair<Double , Long>>>>()
            val job = CoroutineScope(Dispatchers.IO).launch {
                getAllTopics().onEach { topicUid ->
                    val values = async {
                        questionMetadataDao.getAllMetadataForTopic(topicUid.uid, userUid)
                            .map { Pair( it.weight , it.questionUid ) }
                            .toTypedArray()
                    }
                    Log.d("Debug" , "TopicUid = $topicUid -> questionUids : ${values.await().map { it.second }.toString()}" )
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

    override suspend fun getQuestionByUid(questionUid: Long): Question? {
        return questionMetadataDao.getQuestionByUid(questionUid)
    }
}