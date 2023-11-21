package com.example.chatbot.common.services.api_key_fetcher

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


/**
* An implementation of the [APIKeyFetcher] interface that retrieves API keys from Firestore Storage.
*/
class FirestoreKeyFetcher : APIKeyFetcher {

    private val collectionRef =
        Firebase.firestore.collection(APIKeyFetcher.COLLECTION_NAME) // this object contains methods to interact with the database

    // to access any document inside the collection
    // val task = collectionRef.document(your document name).get() // you store the request inside 'task variable'
    // task.await() // with this you say - wait until the request is finished -; if not used, the following lines will be executed without waiting for completion
    // if(task.isSuccessful)
    //     val key = task.result.get( your field name) as String? // you get the field that has the name you want and interpret it as a possibly null string
    //     write then the logic to handle the case when the key is null or not
    //     use return Result.success(key) if key is not null
    //     use return Result.failure(NullPointerException("$fieldName content not found or is null")) if the key is null //
    // else
    //     return Result.failure(task.exception ?:Exception("Unknown error has occurred while retrieving field $fieldName from document $documentName")) if the task is not successful
    // leftArg ?: rightArg is short for if(leftArg  == null ) rightArg
override suspend fun getAPIKey(documentName: String, fieldName: String ): Result<String> {

        //https://firebase.google.com/docs/firestore/manage-data/add-data#kotlin+ktx_1
        // resources on how it works and how to use
        // make sure you check the code snippet ofr android and KotlinX
        TODO("Not Yet Implemented")

    }
}