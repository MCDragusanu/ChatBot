package com.example.chatbot.common

/**
 * An enumeration representing various UI states.
 *
 * UIState defines different states that a user interface element can be in, such as enabled, pressed, loading, completed,
 * or indicating an error condition.
 */
enum class UIState {
    /**
     * Represents the UI element in an enabled state, ready for interaction.
     */
    Enabled,

    /**
     * Represents the UI element in a pressed state, indicating a user interaction such as a button press.
     */
    Pressed,

    /**
     * Represents the UI element in a loading state, typically used for indicating ongoing background processes.
     */
    Loading,

    /**
     * Represents the UI element in a completed state, signaling the successful completion of an operation or task.
     */
    Completed,

    /**
     * Represents the UI element in an error state, indicating a problem or failure condition.
     */
    Error;

    /**
     * Checks if the UI element is in the Enabled state.
     *
     * @return True if the UI element is in the Enabled state, false otherwise.
     */
    fun isEnabled(): Boolean {
        return this == Enabled
    }

    /**
     * Checks if the UI element is in the Pressed state.
     *
     * @return True if the UI element is in the Pressed state, false otherwise.
     */
    fun isPressed(): Boolean {
        return this == Pressed
    }

    /**
     * Checks if the UI element is in the Loading state.
     *
     * @return True if the UI element is in the Loading state, false otherwise.
     */
    fun isLoading(): Boolean {
        return this == Loading
    }

    /**
     * Checks if the UI element is in the Completed state.
     *
     * @return True if the UI element is in the Completed state, false otherwise.
     */
    fun isCompleted(): Boolean {
        return this == Completed
    }

    /**
     * Checks if the UI element is in the Error state.
     *
     * @return True if the UI element is in the Error state, false otherwise.
     */
    fun isError(): Boolean {
        return this == Error
    }
}
