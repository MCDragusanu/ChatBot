package com.example.chatbot.main.data.question_metadata_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents metadata for a question stored in the database.
 *
 * @property uid Unique identifier for the question.
 * @property grade Grade associated with the question.
 * @property statusCode Status code indicating the status of the question (DEFAULT, COMPLETED, WRONG).
 * @property questionUid Unique identifier for the question.
 * @property questionContent Content of the question.
 * @property correctAnswer Correct answer to the question.
 * @property topicUid Unique identifier of the topic associated with the question.
 * @property weight Weight of the question.
 */
@Entity(tableName = "question_metadata_table")
data class QuestionMetadata(
    @PrimaryKey val uid: Long,
    val grade: Float,
    val statusCode: Int,
    val questionUid: Int,
    val questionContent: String,
    val correctAnswer: String,
    val topicUid: Int,
    val weight: Double
) {
    companion object {
        // Constants representing different question statuses
        const val DEFAULT = 0
        const val COMPLETED = 1
        const val WRONG = 2
    }
}
