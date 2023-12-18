package com.example.chatbot.main.domain.use_cases

import android.util.Log
import com.example.chatbot.main.data.module.MainModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async

object SyncronizeTopics {
   suspend fun execute(mainModule: MainModule , scope: CoroutineScope){
        //check if topics database is empty
        if(mainModule.questionRepository.noTopicsCached()){
            //retrieve from cloud
            val topics = mainModule.cloudDataSource.getTopics(mainModule.source)

            topics.onSuccess {
                it.onEach {
                    scope.async {
                        //add to local database
                        mainModule.questionRepository.addTopic(it)
                    }
                }
            }
        } else {
            Log.d("Test" , "Topics are cached locally")
        }
    }
}