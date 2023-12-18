package com.example.chatbot.main.domain.use_cases

import android.util.Log
import com.example.chatbot.main.data.database_messages.repository.ConversationRepository
import com.example.chatbot.main.domain.model.ConversationThread
import com.example.chatbot.main.domain.model.Session
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object RetrieveSessionImpl:RetrieveSession {

    // UseCase to retrieve a session from local storage by sessionUid
    // Input: sessionUid - Unique identifier for the session, repository - Data repository for conversations
    // Output: Result<Session> - Success with the retrieved session or Failure with an exception
   override suspend fun execute(sessionUid: Long, repository: ConversationRepository): Result<Session> {
        return try {
            // Step 1: Retrieve session metadata from the repository
            val sessionMetadata = repository.retrieveSessionByUid(sessionUid)

            // Step 2: Check if the session is found
            if (sessionMetadata == null) {
                throw Exception("No session found")
            }

            // Step 3: Retrieve threads metadata for the session
            val threads = mutableListOf<ConversationThread>()

            val job = CoroutineScope(Dispatchers.IO).launch {
                val threadsMetadata = repository.retrieveThreadsForSession(sessionUid)

                if(threadsMetadata.isEmpty()){
                  Log.d("Test" , "No Threads found")
                  return@launch
                }
                // Step 4: Iterate through each thread metadata
                threadsMetadata.onEach {
                    // Step 5: Asynchronously retrieve messages, question, and instruction for each thread
                    val messages = async {
                        repository.retrieveMessagesForThread(it.uid)
                    }
                    val question = async {
                        repository.retrieveQuestionByUid(it.questionUid)
                    }
                    val instruction = async {
                        repository.retrieveInstructionForThread(it.questionUid)
                    }

                    // Step 6: Create a ConversationThread object and add it to the list of threads
                    threads.add(
                        ConversationThread(
                            threadMetadata = it,
                            messages = messages.await(),
                            question = question.await()?:throw Exception("No Question found"),
                            instruction = instruction.await()
                                ?: throw NullPointerException("No Instruction Found")
                        )
                    )
                }
                return@launch
            }

            // Step 7: Wait for all thread retrieval operations to complete
            job.join()

            // Step 8: Return the Result with the successfully retrieved Session
            Result.success(Session(metadata = sessionMetadata, threads))

        } catch (e: Exception) {
            // Step 9: Handle any exceptions and return a Result with failure
            e.printStackTrace()
            Result.failure(e)
        }
    }
}
