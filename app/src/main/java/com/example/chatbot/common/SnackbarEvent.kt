package com.example.chatbot.common

/**
 * A class representing an event to display a Snackbar message with specific content and styling.
 *
 * @param messageCode An integer code representing the message content or resource.
 * @param eventType The type of Snackbar event, which determines its visual styling and behavior.
 */
class SnackbarEvent(val messageCode: Int, eventType: EventType) {
    /**
     * An enumeration of event types that define the visual styling and behavior of the Snackbar.
     */
    enum class EventType {
        /**
         * Represents a Snackbar event with a general informational popup styling.
         */
        Popup,

        /**
         * Represents a Snackbar event indicating an error condition with distinct error styling.
         */
        Error,

        /**
         * Represents a Snackbar event that requires user confirmation or interaction, styled accordingly.
         */
        Confirmation
    }
}
