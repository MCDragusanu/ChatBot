package com.example.chatbot.main.domain.instruction_factory

import kotlinx.serialization.Serializable

@Serializable
  class GPTResponse(val type:String = "DEFAULT", val content: String   = "DEFAULT", val aux :String = " ") {
    /**
     * Default implementation of [GPTResponse].
     */

  }