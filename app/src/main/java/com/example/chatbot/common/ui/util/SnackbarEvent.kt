package com.example.chatbot.common.ui.util

/**
 * A class representing an event to display a Snackbar message with specific content and styling.
 *
 * @param message message content or resource.
 * @param eventType The type of Snackbar event, which determines its visual styling and behavior.
 */
class SnackbarEvent(val message: String, val eventType: EventType) {
    /**
     * An enumeration of event types that define the visual styling and behavior of the Snackbar.
     */
    enum class EventType {
        Popup,
        Error,
        Confirmation
    }
}
