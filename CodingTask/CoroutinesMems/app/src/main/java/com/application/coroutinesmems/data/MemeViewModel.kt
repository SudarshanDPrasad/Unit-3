package com.application.coroutinesmems.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemeViewModel : ViewModel() {

    private val repo = MemsRepo()
    private val mutableLiveData = MutableLiveData<MainUIMode>()
    val liveData: LiveData<MainUIMode> = mutableLiveData

    fun callApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val data = repo.getALLData()
            if (data != null) {
                mutableLiveData.postValue(MainUIMode.OnSucces(data))
            }else {
                mutableLiveData.postValue(MainUIMode.OnFailure("Error"))
            }
        }
    }
}