package com.example.chatbot.main.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot.main.data.module.MainModule
import com.example.chatbot.main.data.database_questions.entity.TopicMetadata
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeScreenViewModel:ViewModel() {

    private lateinit var module:MainModule

    private val _topics = MutableStateFlow<List<TopicMetadata>>(emptyList())
    val topics = _topics.asStateFlow()


    fun setModule(newModule: MainModule) {
        this.module = newModule
        viewModelScope.launch(Dispatchers.IO) {
            _topics.update {
                module.questionRepository.getAllTopics()
            }
        }
    }
    fun getCurrentUser() = module.currentUser
     fun getQuestionsMetadataForTopic(topicUid:Int) : Flow<List<Int>> = flow {
         emit(
             module.questionRepository.getAllMetadataForTopic(topicUid, module.currentUser.uid)
                 .map {it.status })
     }
}