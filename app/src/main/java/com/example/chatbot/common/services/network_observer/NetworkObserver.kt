package com.example.chatbot.common.services.network_observer

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow

interface NetworkObserver {

    enum class NetworkStatus {
        Available,
        Unavailable,
        Loosing,
        Lost;
        fun isOnline() = this == Available
        fun isOffline() =!isOnline()
    }


    suspend fun monitorConnection(externalScope : CoroutineScope): SharedFlow<Boolean>

    fun getStatus():Boolean

}