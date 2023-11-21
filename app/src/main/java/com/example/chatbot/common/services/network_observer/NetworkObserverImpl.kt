package com.example.chatbot.common.services.network_observer

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.shareIn

class NetworkObserverImpl(private val context: Context): NetworkObserver {
    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override suspend fun monitorConnection(externalScope: CoroutineScope): SharedFlow<Boolean> {
        return callbackFlow<Boolean> {
            val callback = object : ConnectivityManager.NetworkCallback(){
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    trySend( true)
                }

                override fun onLost(network: Network) {
                    super.onLost(network)

                    trySend( false)
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    trySend(false)
                }
            }
            val request = NetworkRequest.Builder().addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET).build()
            connectivityManager.registerNetworkCallback(request , callback)
            awaitClose {
                connectivityManager.unregisterNetworkCallback(callback)
            }
        }.shareIn(externalScope , started = SharingStarted.WhileSubscribed())
    }

    override fun getStatus() : Boolean {

        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as  ConnectivityManager
        val netInfo = cm.activeNetwork
        return netInfo != null

    }
}