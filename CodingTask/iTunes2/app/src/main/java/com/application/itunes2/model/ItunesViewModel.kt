package com.application.itunes2.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.application.itunessong.responsemodel.ResponseDTO
import com.application.itunessong.responsemodel.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class ItunesViewModel @Inject constructor(var itunesRepo: ItunesRepo) : ViewModel() {

    fun getData(query: String): LiveData<Resource<ResponseDTO>> {
        return liveData(Dispatchers.IO) {
            val data = itunesRepo.getApiCall(query)
            emit(data)
        }
    }


    fun addApiData(ituneTable: List<Result>) {
        itunesRepo.addtoDB(ituneTable)
    }

    fun songsfromDb(query: String): LiveData<List<Result>> {
        return itunesRepo.getSongs(query)
    }
}