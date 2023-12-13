package com.example.chatbot.main.data.question_metadata_database.cloud

import com.example.chatbot.main.data.question_metadata_database.entity.QuestionMetadata
import com.example.chatbot.main.data.question_metadata_database.entity.TopicMetadata

/**
 * An interface representing a cloud data source that provides methods to interact with topics and questions.
 */
interface CloudDataSource {

    /**
     * Adds a new topic to the cloud data source.
     *
     * @param topic The metadata of the topic to be added.
     * @param source The type of the database where the topic will be added (Project or Production).
     * @return A Result object indicating the success or failure of the operation.
     */
    suspend fun addTopic(topic: TopicMetadata, source: DatabaseType): Result<Unit>

    /**
     * Adds a list of questions to the cloud data source.
     *
     * @param questions The list of question metadata to be added.
     * @param source The type of the database where the questions will be added (Project or Production).
     * @return A Result object indicating the success or failure of the operation.
     */
    suspend fun addQuestions(questions: List<QuestionMetadata>, source: DatabaseType): Result<Unit>

    /**
     * Retrieves a topic from the cloud data source based on its unique identifier (UID).
     *
     * @param uid The unique identifier of the topic to be retrieved.
     * @param source The type of the database where the topic will be retrieved (Project or Production).
     * @return A Result object containing the retrieved TopicMetadata or an error.
     */
    suspend fun getTopicByUid(uid: Int, source: DatabaseType): Result<TopicMetadata>

    /**
     * Retrieves a list of questions associated with a specific topic from the cloud data source.
     *
     * @param topic The topic for which questions are to be retrieved.
     * @param source The type of the database where the questions will be retrieved (Project or Production).
     * @return A Result object containing the retrieved list of QuestionMetadata or an error.
     */
    suspend fun getQuestionsForTopic(topic: TopicMetadata, source: DatabaseType): Result<List<QuestionMetadata>>

    /**
     * Sealed class representing different database types (Project and Production).
     *
     * @param topicCollection The name of the collection where topics are stored.
     * @param questionCollection The name of the collection where questions are stored.
     */
    sealed class DatabaseType(val topicCollection: String, val questionCollection: String) {
        object ProjectDatabase : DatabaseType("Project Topic Collection", "Project Question Collection")
        object ProductionDatabase : DatabaseType("Production Topic Collection", "Production Question Collection")
    }
}

