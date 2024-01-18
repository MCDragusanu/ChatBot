package com.example.chatbot.main.presentation.game_screen.controllers

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.chatbot.main.data.database_messages.model.QuizMetadata
import com.example.chatbot.main.data.database_questions.entity.QuestionMetadata
import com.example.chatbot.main.presentation.game_screen.layouts.MultiChoiceQuizLayout
import com.example.chatbot.main.presentation.game_screen.model.QuizEvent
import com.example.chatbot.main.presentation.game_screen.model.QuizState
import com.example.chatbot.main.presentation.game_screen.layouts.QuizLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MultiChoiceController() : QuizController() {
    private val _quizState = MutableStateFlow<QuizState.MultiChoiceQuizState?>(null)


    override var quizLayout: QuizLayout
        get() = MultiChoiceQuizLayout
        set(value) {}
    override fun loadResources() {
        parent.viewModelScope.launch(Dispatchers.IO) {
            try{
                _screenState.update { QuizState.PossibleState.Loading }
                val question =
                    parent.module.questionRepository.getQuestionByUid(this@MultiChoiceController.quizMetadata.questionUid)
                        ?: throw NullPointerException("Failed to retrieve Question")
                val topicName = parent.module.questionRepository.getTopicName(question.topicUid)
                val allAnswers = (question.incorrectAnswers.split("/")
                    .filter { it.isNotBlank() } + question.correctAnswer).shuffled()
                val state = QuizState.MultiChoiceQuizState(
                    question.questionContent,
                    topicName = topicName,
                    allAnswers = allAnswers,
                    correctAnswerIndex = allAnswers.indexOfFirst { it == question.correctAnswer },
                    currentPickedAnswer = -1,
                    topicUid = question.topicUid,
                    questionUid = question.uid,
                    isLoading = false
                )
                _quizState.update { state }
                _screenState.update { QuizState.PossibleState.Default }
            }catch (e:Exception){
                e.printStackTrace()
                _screenState.update { QuizState.PossibleState.FailedToLoad }
            }
        }
    }

    override fun presentState(): StateFlow<QuizState?> {
        return _quizState.asStateFlow()
    }

    override fun onEvent(event: QuizEvent) {
        when(event){
            is QuizEvent.NewAnswerPicked->{
                _quizState.update { it?.copy(currentPickedAnswer = event.index) }
            }
            is QuizEvent.QuizSubmission->{
               // if(_quizState.value?.currentPickedAnswer == _quizState.value?.correctAnswerIndex){
                    _screenState.update { QuizState.PossibleState.Completed }
                    updateQuestionMetadata(_quizState.value?.isCorrect()?:false)
                //}

            }
            else ->{/*Ignore*/}
        }
    }

    fun updateQuestionMetadata(isCorrect:Boolean){
        _quizState.value?.let {state->
            parent.viewModelScope.launch {

               val metadata =  parent.module.questionRepository.getMetadataByQuestionUid(questionUid =state.questionUid , userUid = parent.module.currentUser.uid)
                if(metadata != null){
                    val updated = metadata.copy(currentGrade = if(isCorrect) 10.0 else 1.0,status = if(isCorrect) QuestionMetadata.COMPLETED else QuestionMetadata.WRONG).apply { this.uid = metadata.uid }
                   parent.module.questionRepository.updateQuestionMetadata(updated)
                    Log.d("Test" , "Question Metadata Updated! ${updated}")
                }
            }
        }
    }
    override fun getQuestion(): String {
        return ""
    }
}