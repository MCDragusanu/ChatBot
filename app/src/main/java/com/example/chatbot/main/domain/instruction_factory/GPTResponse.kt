package com.example.chatbot.main.domain.instruction_factory

sealed class GPTResponse(
    val message: String,
    val currentGrade: Float,
    val isFinished: Boolean,
    val className: String
) {
    /**
     * Default implementation of [GPTResponse].
     */
    class Default(
        message: String,
        currentGrade: Float,
        isFinished: Boolean
    ) : GPTResponse(message, currentGrade, isFinished, "DEFAULT")
}