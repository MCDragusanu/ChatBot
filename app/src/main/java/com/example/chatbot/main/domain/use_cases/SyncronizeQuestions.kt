package com.example.chatbot.main.domain.use_cases

import android.util.Log
import com.example.chatbot.main.data.module.MainModule
import com.example.chatbot.main.data.database_questions.entity.QuestionMetadata
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async

object SyncronizeQuestions {

    suspend fun execute(module: MainModule , scope: CoroutineScope){
        //check to see if question database is empty
        if (module.questionRepository.noQuestionsCached()) {

            //retrieve from cloud database
            val questions = module.cloudDataSource.getQuestions(module.source)

            questions.onSuccess {

                it.onEach {question->
                    scope.async {
                        //check to see if there is a metadata linked to the question
                        if(module.questionRepository.getMetadataByQuestionUid(question.questionUid , module.currentUser.uid) == null){
                            //create new metadata
                            val metadata = QuestionMetadata(userUid = module.currentUser.uid , questionRowUid = question.uid)
                            //insert to table
                            module.questionRepository.addQuestionMetadata(metadata)
                        }
                    }
                    //insert into table new queston
                    scope.async {
                        module.questionRepository.addQuestionRow(question)
                    }
                }
            }.onFailure {
                it.printStackTrace()
                return
            }
        }
        else {
            Log.d("Test" , "Questions are chached locally")
        }
    }
}