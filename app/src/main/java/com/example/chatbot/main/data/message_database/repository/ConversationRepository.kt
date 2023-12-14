package com.example.chatbot.main.data.message_database.repository

import com.example.chatbot.main.data.message_database.model.Instruction
import com.example.chatbot.main.data.message_database.model.Message
import com.example.chatbot.main.data.message_database.model.SessionMetadata
import com.example.chatbot.main.data.message_database.model.ThreadMetadata
import com.example.chatbot.main.data.question_metadata_database.entity.QuestionMetadata

/**
 * Repository interface for managing conversations in the local storage database.
 * This interface defines methods to interact with different entities such as messages, threads, sessions, questions, and instructions.
 */
interface ConversationRepository {

    /**
     * Retrieves messages associated with a specific thread.
     *
     * @param threadUid Unique identifier for the thread.
     * @return List of messages in the specified thread.
     */
    suspend fun retrieveMessagesForThread(threadUid: Long): List<Message>

    /**
     * Retrieves thread metadata associated with a specific session.
     *
     * @param sessionMetadataUid Unique identifier for the session metadata.
     * @return List of thread metadata associated with the specified session.
     */
    suspend fun retrieveThreadsForSession(sessionMetadataUid: Long): List<ThreadMetadata>

    /**
     * Retrieves session metadata based on its unique identifier.
     *
     * @param sessionUid Unique identifier for the session.
     * @return SessionMetadata object if found, otherwise null.
     */
    suspend fun retrieveSessionByUid(sessionUid: Long): SessionMetadata?

    /**
     * Retrieves a question based on its unique identifier.
     *
     * @param questionUid Unique identifier for the question.
     * @return Question object if found, otherwise null.
     */
    suspend fun retrieveQuestionByUid(questionUid: Long): QuestionMetadata?

    /**
     * Retrieves an instruction based on the unique identifier of the associated thread.
     *
     * @param instructionUid Unique identifier for the question associated with the thread.
     * @return Instruction object if found, otherwise null.
     */
    suspend fun retrieveInstructionForThread(instructionUid: Long): Instruction?

    /**
     * Adds a new message to the local storage.
     *
     * @param message The message to be added.
     * @return Result indicating success or failure of the operation.
     */
    suspend fun addMessage(message: Message): Result<Unit>

    /**
     * Adds thread metadata to the local storage.
     *
     * @param threadMetadata The thread metadata to be added.
     */
    suspend fun addThreadMetadata(threadMetadata: ThreadMetadata)

    /**
     * Adds a new question to the local storage.
     *
     * @param question The question to be added.
     * @return Result indicating success or failure of the operation.
     */
    suspend fun addQuestion(question: QuestionMetadata): Result<Unit>

    /**
     * Adds a new instruction to the local storage.
     *
     * @param instruction The instruction to be added.
     * @return Result indicating success or failure of the operation.
     */
    suspend fun addInstruction(instruction: Instruction): Result<Unit>

    /**
     * Adds session metadata to the local storage.
     *
     * @param sessionMetadata The session metadata to be added.
     * @return Result indicating success or failure of the operation.
     */
    suspend fun addSessionsMetadata(sessionMetadata: SessionMetadata): Result<Unit>
    
    suspend fun retrieveThreadByUid(threadUid: Long): ThreadMetadata?
}
