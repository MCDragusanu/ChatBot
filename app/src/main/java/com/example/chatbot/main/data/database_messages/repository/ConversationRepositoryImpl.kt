package com.example.chatbot.main.data.database_messages.repository

import com.example.chatbot.main.data.database_messages.dao.SessionMetadataDao
import com.example.chatbot.main.data.database_messages.model.Instruction
import com.example.chatbot.main.data.database_messages.model.Message
import com.example.chatbot.main.data.database_messages.model.SessionMetadata
import com.example.chatbot.main.data.database_messages.model.ThreadMetadata

/**
 * Implementation of the ConversationRepository interface for handling conversation-related data.
 *
 * @param conversationDao DAO for accessing conversation-related entities in the local database.
 */
class ConversationRepositoryImpl(private val conversationDao: SessionMetadataDao) : ConversationRepository {

    /**
     * Retrieves messages for a specific conversation thread.
     *
     * @param threadUid The UID of the conversation thread.
     * @return A list of messages in the specified thread.
     */
    override suspend fun retrieveMessagesForThread(threadUid: Long): List<Message> {
        return conversationDao.getMessagesForThread(threadUid)
    }

    /**
     * Retrieves threads for a specific session.
     *
     * @param sessionMetadataUid The UID of the session metadata.
     * @return A list of threads in the specified session.
     */
    override suspend fun retrieveThreadsForSession(sessionMetadataUid: Long): List<ThreadMetadata> {
        return conversationDao.getAllThreadsForSession(sessionMetadataUid)
    }

    /**
     * Retrieves session metadata by UID.
     *
     * @param sessionUid The UID of the session metadata.
     * @return The session metadata corresponding to the UID.
     */
    override suspend fun retrieveSessionByUid(sessionUid: Long): SessionMetadata? {
        return conversationDao.getMetadataByUid(sessionUid)
    }

    /**
     * Retrieves an instruction by UID.
     *
     * @param instructionUid The UID of the instruction.
     * @return The instruction corresponding to the UID.
     */
    override suspend fun retrieveInstructionForThread(instructionUid: Long): Instruction? {
        return conversationDao.getInstructionByUid(instructionUid)
    }

    /**
     * Adds a message to the local database.
     *
     * @param message The message to be added.
     * @return Result<Unit> indicating success or failure.
     */
    override suspend fun addMessage(message: Message): Result<Unit> {
        return try {
            conversationDao.addMessage(message)
            Result.success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    /**
     * Adds thread metadata to the local database.
     *
     * @param threadMetadata The thread metadata to be added.
     * @return Result<Unit> indicating success or failure.
     */
    override suspend fun addThreadMetadata(threadMetadata: ThreadMetadata): Result<Unit> {
        return try {
            conversationDao.addThread(threadMetadata)
            Result.success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    /**
     * Adds an instruction to the local database.
     *
     * @param instruction The instruction to be added.
     * @return Result<Unit> indicating success or failure.
     */
    override suspend fun addInstruction(instruction: Instruction): Result<Unit> {
        return try {
            conversationDao.addInstruction(instruction)
            Result.success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    /**
     * Adds session metadata to the local database.
     *
     * @param sessionMetadata The session metadata to be added.
     * @return Result<Unit> indicating success or failure.
     */
    override suspend fun addSessionsMetadata(sessionMetadata: SessionMetadata): Result<Unit> {
        return try {
            conversationDao.addSessionMetadata(sessionMetadata)
            Result.success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    /**
     * Retrieves a thread by UID.
     *
     * @param threadUid The UID of the thread.
     * @return The thread corresponding to the UID.
     */
    override suspend fun retrieveThreadByUid(threadUid: Long): ThreadMetadata? {
        return conversationDao.getThreadByUid(threadUid)
    }

    /**
     * Retrieves sessions for a specific user.
     *
     * @param uid The UID of the user.
     * @return A list of sessions associated with the specified user.
     */
    override suspend fun retrieveSessionsByUserUid(uid: String): List<SessionMetadata> {
        return conversationDao.getSessionsForUser(uid)
    }
}
