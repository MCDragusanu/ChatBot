package com.example.chatbot.main.domain.instruction_factory

import android.util.Log
import com.example.chatbot.main.data.database_messages.model.Instruction
import com.example.chatbot.main.data.database_questions.entity.Question

class InstructionFactory {

    fun buildInstruction(format: GPTResponseFormat, questionRow: Question, instructionUid: Long, threadUID: Long): Instruction {

        val preamble = "${format.preamble}\n"
        val instructionContent = buildJSONStructure(format)
        val  questionContent = "\nquestion : ${questionRow.questionContent}\n"+"correctAnswer : ${questionRow.correctAnswer}"
        val ending =
            "It is crucial to adhere to this structure to assure that our client can process this message and display the correct information to the user"

        val instructionBody = "$preamble$questionContent$instructionContent$ending"
        Log.d("Test", instructionBody)

        return Instruction(instructionUid, threadUID, instructionBody)
    }

    private fun buildJSONStructure(format: GPTResponseFormat) = buildString {
        append("dataType: ${format.className}  (this is a flag to determine the correct class that will encapsulate your response)\n")
        append("{\n")
        format.fields.forEachIndexed { index, fieldDescriptor ->
            append("\t${fieldDescriptor.fieldName} of type ${fieldDescriptor.valueType}: (${fieldDescriptor.explanation})")
            if (index < format.fields.size - 1) {
                append(",")
            }
            append("\n")
        }
        append("}\n")
    }
}