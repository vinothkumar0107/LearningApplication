package com.example.audio.mvvm_api_call

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository {
    val backgroundScope = CoroutineScope(Dispatchers.IO)
    val foregroundScope = CoroutineScope(Dispatchers.Main)
    var apiService = ApiEndpointServices.apiCilent()

    suspend fun callApi():ResponseModelClass{
        return  apiService.getPropertyList("")
    }
}