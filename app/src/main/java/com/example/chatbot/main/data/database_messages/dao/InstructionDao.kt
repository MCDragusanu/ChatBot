package com.example.chatbot.main.data.database_messages.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.chatbot.main.data.database_messages.model.Instruction


/**
 * Data Access Object (DAO) for managing instructions in the local storage database.
 */
@Dao
interface InstructionDao {

    /**
     * Adds a new instruction to the local storage.
     *
     * @param instructionDao The instruction to be added.
     */
    @Insert
    suspend fun addInstruction(instructionDao: Instruction)

    /**
     * Deletes an existing instruction from the local storage.
     *
     * @param instruction The instruction to be deleted.
     */
    @Delete
    suspend fun deleteInstruction(instruction: Instruction)

    /**
     * Updates an existing instruction in the local storage.
     *
     * @param instruction The updated instruction.
     */
    @Update
    suspend fun updateInstruction(instruction: Instruction)

    /**
     * Retrieves an instruction based on its unique identifier.
     *
     * @param instructionUid Unique identifier for the instruction.
     * @return Instruction object if found, otherwise null.
     */
    @Query("SELECT * from instruction_table where uid = :instructionUid")
    suspend fun getInstructionByUid(instructionUid: Long): Instruction?

    /**
     * Deletes an instruction based on its unique identifier.
     *
     * @param instructionUid Unique identifier for the instruction to be deleted.
     */
    @Query("DELETE from instruction_table where uid = :instructionUid")
    suspend fun deleteInstructionByUid(instructionUid: Long)
}
