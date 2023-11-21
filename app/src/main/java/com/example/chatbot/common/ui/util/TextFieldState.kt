package com.example.chatbot.common.ui.util

/**
 * A data class representing the state of a text field within a user interface.
 *
 * This class encapsulates the content of the text field, an optional error code, and the UI state of the text field.
 *
 * @param content The text content of the text field.
 * @param errorCode An optional error code, which is null when there is no error.
 * @param state The state of the text field, such as whether it's enabled, pressed, loading, completed, or indicating an error condition.
 */
data class TextFieldState(
    val content: String = "",
    val errorCode: Int? = null,
    val state: UIState = UIState.Enabled
)

