package com.example.chatbot.main.domain.use_cases

import com.example.chatbot.main.data.database_messages.repository.ConversationRepository
import com.example.chatbot.main.data.database_questions.local.QuestionRepository
import com.example.chatbot.main.domain.model.ConversationThread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * Object responsible for retrieving a conversation thread using the provided thread UID.
 *
 * @property threadUid Unique identifier for the conversation thread to be retrieved.
 * @property conversationRepository Repository for managing conversations in the local storage database.
 */
object RetrieveConversationThreadImpl : RetrieveConversationThread {

    /**
     * Executes the retrieval of a conversation thread based on the provided thread UID.
     *
     * @param threadUid Unique identifier for the conversation thread.
     * @param conversationRepository Repository for managing conversations in the local storage database.
     * @return Result<ConversationThread> indicating success with the retrieved thread or failure with an exception.
     */
    override suspend fun execute(threadUid: Long, conversationRepository: ConversationRepository , questionRepository: QuestionRepository): Result<ConversationThread> {
        return try {
            // Step 1: Retrieve thread metadata from the repository
            val threadMetadata = conversationRepository.retrieveThreadByUid(threadUid)

            // Step 2: Check if the thread metadata is found
            if (threadMetadata == null) {
                throw NullPointerException("No metadata found")
            }

            var conversationThread: ConversationThread? = null

            // Step 3: Launch a coroutine to asynchronously retrieve related information for the thread
            val job = CoroutineScope(Dispatchers.IO).launch {
                val question = async { questionRepository.getQuestionByUid(threadMetadata.questionUid) }.await()
                    ?: throw NullPointerException("No Question Found")
                val instruction =
                    async { conversationRepository.retrieveInstructionForThread(threadMetadata.instructionUid) }.await()
                        ?: throw NullPointerException("No Instruction Found")
                val messages = async { conversationRepository.retrieveMessagesForThread(threadUid) }.await()

                // Step 4: Create a ConversationThread object with the retrieved information
                conversationThread = ConversationThread(
                    quizMetadata = threadMetadata,
                    messages = messages,
                    instruction = instruction,
                    question = question
                )
            }

            // Step 5: Wait for the asynchronous operations to complete
            job.join()

            // Step 6: Return the Result with the successfully retrieved ConversationThread or failure if not found
            if (conversationThread == null) Result.failure(NullPointerException("Failed to retrieve conversation thread"))
            else Result.success(conversationThread!!)

        } catch (e: Exception) {
            // Step 7: Handle any exceptions and return a Result with failure
            e.printStackTrace()
            Result.failure(e)
        }
    }
}

