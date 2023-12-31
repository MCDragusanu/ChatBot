package com.example.chatbot.main.presentation.game_screen.state_manager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot.main.data.database_messages.model.SessionMetadata
import com.example.chatbot.main.data.database_messages.model.QuizMetadata
import com.example.chatbot.main.data.module.MainModule
import com.example.chatbot.main.presentation.game_screen.controllers.MultiChoiceController
import com.example.chatbot.main.presentation.game_screen.controllers.OpenEndedQuestionController
import com.example.chatbot.main.presentation.game_screen.controllers.QuizController
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
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
    private val _controllers = mutableListOf<QuizController>()

    // Index representing the current quiz controller in the session.
    private var _currentControllerIndex = MutableStateFlow(-1)

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
            }
        }
    }




    /**
     * Handles the completion of a quiz and updates the current quiz controller index.
     *
     * @param threadUID The UID of the completed quiz thread.
     */
    fun onQuizCompleted(threadUID: Long) {
        _currentControllerIndex.update { if (it + 1 in _quizList.indices) it + 1 else it }
    }

    /**
     * Placeholder function for handling navigation to the next quiz.
     */
    fun onNextQuiz() {
        // TODO: Implement logic for navigating to the next quiz.
    }

    /**
     * Placeholder function for handling navigation to the previous quiz.
     */
    fun onPrevQuiz() {
        // TODO: Implement logic for navigating to the previous quiz.
    }

    /**
     * Placeholder function for handling errors.
     *
     * @param exception The exception to be handled.
     */
    fun onError(exception: Exception) {
        // TODO: Implement error handling logic.
    }
}
