package com.example.chatbot.common.services.uid_generator

import kotlin.random.Random


class UIDGeneratorImpl: UIDGenerator {
    override fun generateLong(): Long {
      return System.currentTimeMillis()
    }

    override fun generateString(): String {
       return Random(System.currentTimeMillis()).nextBytes(256 / 8).decodeToString()
    }
}