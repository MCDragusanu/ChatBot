package com.example.chatbot.main.data.message_database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents an instruction entity in the local storage database.
 *
 * The instances of this class are stored in a table named "instruction_table" using Room Persistence Library.
 *
 * @property uid Unique identifier for the instruction. Each instruction has a distinct identifier.
 * @property content The content of the instruction, providing detailed guidance or information.
 *
 * @Entity(tableName = "instruction_table")
 * Indicates that instances of this class will be stored in a table named "instruction_table" in the local database.
 */
@Entity(tableName = "instruction_table")
class Instruction(
    @PrimaryKey val uid: Long,
    val threadUid:Long,
    val content: String
)
