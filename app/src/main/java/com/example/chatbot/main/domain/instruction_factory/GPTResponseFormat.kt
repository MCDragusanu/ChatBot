package com.example.chatbot.main.domain.instruction_factory



/**
 * Represents the format expected for responses in the GPT interview game.
 * @property preamble A message providing instructions and context for the game.
 * @property fields List of [FieldDescriptor] describing the expected fields in the response.
 * @property className The class name associated with this format.
 */
sealed class GPTResponseFormat(
    val preamble: String,
  //  val fields: List<FieldDescriptor>,
    val ending : String,
   // val className: String
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
        preamble = "Moderation Guidelines for Quiz Game:\n" +
                "\n" +
                "As the quiz game moderator, when responding to questions and correct answers, follow this precise format:\n" +
                "\n" +
                "Response Structure:\n" +
                "\n" +
                "Every response MUST start and end with these specific Letters: F for follow up , S for suggestion , and E for ending" +
                "Use the corresponding Letter based on the context.\n" +
                "\n" +
                "If the user requests hints, respond ONLY with <suggestion>" +
                "If the user provides a correct answer, respond ONLY with <ending> and NO additional tags.\n" +
                "Response Examples:\n" +
                "\n" +
                "<follow-up> Your response to the user's message - this will be the default response type</follow-up>\n" +
                "<suggestion> Guide the user towards the correct answer</suggestion>\n" +
                "<ending> Grade (1-10) and a final comment separated like this: grade/comment, use only '/'</ending>\n" +
                "Important Reminder:\n" +
                "Ensure that EVERY response has the appropriate opening and closing tags like XML. Use <suggestion> for hints. If the user provides a correct answer, respond ONLY with <ending>. Consistency is CRUCIAL for effective moderation.",ending = ""
        /*     ,

        fields = listOf(
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
        ending ="",
        className = "DEFAULT"*/
    )
}





