package com.example.chatbot.main.domain.instruction_factory

import android.util.Log
import com.example.chatbot.main.data.database_messages.model.Instruction
import com.example.chatbot.main.data.database_questions.entity.Question
import com.example.chatbot.main.domain.instruction_factory.GPTResponseFormat.DefaultFormat.ending

class InstructionFactory {

    fun buildInstruction(format: GPTResponseFormat, questionRow: Question, instructionUid: Long, threadUID: Long): Instruction {
        val  questionContent = "\nquestion : ${questionRow.questionContent}\n"+"correctAnswer : ${questionRow.correctAnswer}\n"
        val instructionBody = "${format.preamble}${questionContent}${format.ending}"


        return Instruction(instructionUid, threadUID, instructionBody)
    }


}