package com.example.audio.mvvm_api_call

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ResponseViewModel(application: Application) : AndroidViewModel(application){
    val mutableLiveData:MutableLiveData<ResponseModelClass> = MutableLiveData()
    val liveData:LiveData<ResponseModelClass> get() = mutableLiveData

    var repository = Repository()

    fun callRepo(){
        viewModelScope.launch {
            var data = repository.callApi()
            mutableLiveData.postValue(data)
        }
    }

}