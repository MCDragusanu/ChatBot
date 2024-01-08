package com.example.chatbot.main.presentation.game_screen.state_manager

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot.main.data.database_messages.model.SessionMetadata
import com.example.chatbot.main.data.database_messages.model.QuizMetadata
import com.example.chatbot.main.data.database_questions.entity.QuestionMetadata
import com.example.chatbot.main.data.module.MainModule
import com.example.chatbot.main.presentation.game_screen.controllers.MultiChoiceController
import com.example.chatbot.main.presentation.game_screen.controllers.OpenEndedQuestionController
import com.example.chatbot.main.presentation.game_screen.controllers.QuizController
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SessionStateManager : ViewModel() {

    // The MainModule instance, providing dependencies and services.
    lateinit var module: MainModule
        private set

    // List of QuizMetadata representing the quizzes in the current session.
    private var _quizList = emptyList<QuizMetadata>()

    // SessionMetadata representing the current session.
    private var _session: SessionMetadata? = null

    // List of QuizController instances for each quiz in the session.
    private var _controllers = mutableListOf<QuizController>()

    // Index representing the current quiz controller in the session.
    private val _currentControllerIndex = MutableStateFlow(-1)
    val currentControllerIndex = _currentControllerIndex.asStateFlow()

    // StateFlow representing the current quiz controller for observation.
    private val _currentController = MutableStateFlow(_controllers.getOrNull(_currentControllerIndex.value))
    val currentController = _currentController.asStateFlow()



    // CoroutineExceptionHandler for handling exceptions in coroutines.
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError(Exception(throwable))
    }

    /**
     * Sets the MainModule for the session manager, providing dependencies.
     *
     * @param module The MainModule instance.
     */
    fun setModule(module: MainModule) {
        this.module = module
    }

    /**
     * Initializes the quiz session by retrieving session and quiz information.
     *
     * @param sessionUid The UID of the session to be initialized.
     */
    fun initGame(sessionUid: Long) {
        _controllers = mutableListOf()
        _session = null
        _quizList = emptyList()
        _currentController.update { null }
        _currentControllerIndex.update { -1 }
        viewModelScope.launch(Dispatchers.IO) {

            _session = module.conversationRepository.retrieveSessionByUid(sessionUid)
                ?: throw NullPointerException()

            _quizList = module.conversationRepository.retrieveThreadsForSession(sessionUid)

            _quizList.onEach {
                val controller = when (it.type) {
                    QuizMetadata.MULTI_CHOICE -> {
                        MultiChoiceController().apply {
                            this.setListener(this@SessionStateManager)
                            this.setThreadMetadata(it)
                            this.loadResources()
                        }
                    }
                    QuizMetadata.OPEN_ENDED -> {
                        OpenEndedQuestionController().apply {
                            this.setListener(this@SessionStateManager)
                            this.setThreadMetadata(it)
                            this.loadResources()
                        }
                    }
                    else -> null
                }
                controller?.let {
                    _controllers.add(controller)
                }
                _currentControllerIndex.update { if (_controllers.size != 0) 0 else -1 }
                _currentController.update {_controllers.getOrNull(_currentControllerIndex.value)  }
             delay(10)
            }
            Log.d("Test" , " ${_controllers.size } Controllers created")
            _controllers.onEach {
                Log.d("Test" , it.getQuestion())
            }
        }
    }




    /**
     * Handles the completion of a quiz and updates the current quiz controller index.
     *
     * @param threadUID The UID of the completed quiz thread.
     */
    fun onQuizCompleted(quizMetadata: QuizMetadata , grade:Double) {

        _currentControllerIndex.update { if (it + 1 in _quizList.indices) it + 1 else it }
        viewModelScope.launch(Dispatchers.IO) {
            val metadata = module.questionRepository.getMetadataByQuestionUid(
                quizMetadata.questionUid,
                module.currentUser.uid
            )
            if (metadata == null) {
                val newMetadata = QuestionMetadata(
                    module.currentUser.uid,
                    quizMetadata.uid,
                    grade,
                    weight = if (grade >= 7) 10.0 else 9.0
                )
                module.questionRepository.addQuestionMetadata(newMetadata)
                return@launch
            }
            val newWeight =
                if (grade < 7) metadata.weight * (1 - grade / 10.0) else metadata.weight * (1 + grade / 10.0)
            Log.d("Grade", "New Weight for grade = $grade -> $newWeight")
            module.questionRepository.updateQuestionMetadata(
                metadata.copy(

                    currentGrade = grade,
                    weight = newWeight,
                    status =  if (grade < 6) QuestionMetadata.WRONG else QuestionMetadata.COMPLETED
                ).apply { uid = metadata.uid }
            )
        }
    }

    /**
     * Placeholder function for handling navigation to the next quiz.
     */
    fun onNextQuiz() {
        _currentControllerIndex.update {if (it + 1 in _quizList.indices) it + 1 else it  }
        _currentController.update { _controllers.getOrNull(_currentControllerIndex.value) }
    }

    /**
     * Placeholder function for handling navigation to the previous quiz.
     */
    fun onPrevQuiz() {
        _currentControllerIndex.update {if (it-1 in _quizList.indices) it - 1 else it  }
        _currentController.update { _controllers.getOrNull(_currentControllerIndex.value) }
    }

    /**
     * Placeholder function for handling errors.
     *
     * @param exception The exception to be handled.
     */
    fun onError(exception: Exception) {
      exception.printStackTrace()
    }
}
