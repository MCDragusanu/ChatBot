package com.example.chatbot.main.data.question_metadata_database.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * Represents metadata for a topic stored in the database.
 *
 * @property uid Unique identifier for the topic.
 * @property label Label or name associated with the topic.
 * @property keyWords List of keywords associated with the topic.
 * @property imageUid Unique identifier for the image associated with the topic.
 */
@Entity("topic_metadata_table")
data class TopicMetadata(
    @PrimaryKey(autoGenerate = false)
    val uid: Int = 0,
    val label: String = "DEFAULT TOPIC",
    val imageUid: Int = -1  ,
    val keyWords: String = "",
){}
