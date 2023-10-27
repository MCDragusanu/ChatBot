package com.example.chatbot.uid_generator

import kotlin.random.Random


class UIDGeneratorImpl:UIDGenerator {
    override fun generateLong(): Long {
      return Random(System.currentTimeMillis()).nextLong()
    }

    override fun generateString(): String {
       return Random(System.currentTimeMillis()).nextBytes(256 / 8).decodeToString()
    }
}