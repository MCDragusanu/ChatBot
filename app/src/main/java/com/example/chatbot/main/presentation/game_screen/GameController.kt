package com.example.chatbot.main.presentation.game_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot.main.data.database_messages.model.SessionMetadata
import com.example.chatbot.main.data.database_messages.model.ThreadMetadata
import com.example.chatbot.main.data.database_questions.entity.Question
import com.example.chatbot.main.data.module.MainModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.PriorityQueue
import java.util.Queue

class GameController : ViewModel() {
    private val _sessionMetadata = MutableStateFlow<SessionMetadata?>(null)
    val sessionMetadata = _sessionMetadata.asStateFlow()

    private val _threads = MutableStateFlow<List<ThreadMetadata>>(emptyList())
    val threads = _threads.asStateFlow()

    val _currentThreadIndex = MutableStateFlow(_threads.value.indices.first)
    val currentThread = _threads.map { it.getOrNull(_currentThreadIndex.value) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

    private val _questions: StateFlow<List<Question>> = _threads.map {
        if (it.isNotEmpty()) it.map {
            module.questionRepository.getQuestionByUid(it.questionUid)
                ?: throw NullPointerException("No Question found with uid = ${it.uid}")
        } else emptyList()
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private lateinit var module: MainModule

    fun setModule(module: MainModule) {
        this.module = module
    }

    fun nextThread() {
        _currentThreadIndex.update {
            if (it + 1 in _threads.value.indices) it + 1
            else 0
        }
    }

    fun prevThread() {
        _currentThreadIndex.update {
            if (it - 1 in _threads.value.indices) it - 1
            else _threads.value.lastIndex
        }
    }

    fun getQuestionString(threadMetadata: ThreadMetadata): String {
        Log.d("Test" , "QuestionUID = "  + threadMetadata.questionUid)
        return this._questions.value.firstOrNull() { it.uid == threadMetadata.questionUid }?.questionContent?:"TEST"
    }

    fun setSessionUid(sessionUid: Long) {
        if(sessionUid.toInt() != -1)viewModelScope.launch(Dispatchers.IO){
            _sessionMetadata.update {
                module.conversationRepository.retrieveSessionByUid(sessionUid)
            }
            _threads.update {
                module.conversationRepository.retrieveThreadsForSession(sessionUid)
            }
        }
    }


}