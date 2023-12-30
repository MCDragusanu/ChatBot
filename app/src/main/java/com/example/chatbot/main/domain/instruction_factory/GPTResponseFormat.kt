package com.example.chatbot.main.domain.instruction_factory



/**
 * Represents the format expected for responses in the GPT interview game.
 * @property preamble A message providing instructions and context for the game.
 * @property fields List of [FieldDescriptor] describing the expected fields in the response.
 * @property className The class name associated with this format.
 */
sealed class GPTResponseFormat(
    val preamble: String,
    val fields: List<FieldDescriptor>,
    val className: String
) {
    /**
     * Represents a field descriptor in the response format.
     * @property fieldName The name of the field.
     * @property valueType The type of the field value.
     * @property explanation A description/explanation of the field.
     */
    data class FieldDescriptor(
        val fieldName: String,
        val valueType: String,
        val explanation: String
    )

    /**
     * The default response format for the GPT interview game.
     */
    object DefaultFormat : GPTResponseFormat(
        "Let's play a game where you are interviewing a person. You will be given the question itself " +
                "and the objectively correct answer. Your duty is to moderate the conversation about the " +
                "topic given. The rule of the game is to respond with a JSON object with this FIXED structure",
        listOf(
            FieldDescriptor(
                "message",
                "string",
                "Your actual response to the conversation as a string"
            ),
            FieldDescriptor(
                "currentGrade",
                "float",
                "Your grade you give to the current conversion, sum up all the conversation so far " +
                        "and pick a number from 0 to 10.0, 0 being a bad answer and 10 a correct answer"
            ),
            FieldDescriptor(
                "isFinished",
                "bool",
                "0 or 1 if you consider the user has provided all the necessary information to " +
                        "answer the question and finish the game"
            )
        ),
        "DEFAULT"
    )
}

/**
 * Represents a response in the GPT interview game.
 * @property message The response message.
 * @property currentGrade The grade given to the current conversation.
 * @property isFinished Flag indicating if the game is finished.
 * @property className The class name associated with this response.
 */



