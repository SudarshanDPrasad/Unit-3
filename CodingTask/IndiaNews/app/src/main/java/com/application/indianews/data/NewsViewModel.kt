package com.application.indianews.data

import android.app.DownloadManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.application.indianews.reponse.ResponseDTO
import kotlinx.coroutines.Dispatchers

class NewsViewModel : ViewModel() {

    private var newsRepo = NewsRepo()

    fun SportsData(): LiveData<Resource<ResponseDTO>> {
        return liveData(Dispatchers.IO) {
            val data = newsRepo.getSportsData()
            emit(data)
        }
    }

    fun AutoMobileData(): LiveData<Resource<ResponseDTO>> {
        return liveData(Dispatchers.IO) {
            val data = newsRepo.getAutoMobileData()
            emit(data)
        }
    }

    fun BusinessData(): LiveData<Resource<ResponseDTO>> {
        return liveData(Dispatchers.IO) {
            val data = newsRepo.getBusinessData()
            emit(data)
        }
    }


    fun EntertainmentData(): LiveData<Resource<ResponseDTO>> {
        return liveData(Dispatchers.IO) {
            val data = newsRepo.getEntertainmentData()
            emit(data)
        }
    }

    fun TechnologyData(): LiveData<Resource<ResponseDTO>> {
        return liveData(Dispatchers.IO) {
            val data = newsRepo.getTechnologyData()
            emit(data)
        }
    }

    fun NationalData(): LiveData<Resource<ResponseDTO>> {
        return liveData(Dispatchers.IO) {
            val data = newsRepo.getNationalData()
            emit(data)
        }
    }

    fun Querydata(query: String): LiveData<Resource<ResponseDTO>> {
        return liveData(Dispatchers.IO) {
            val data = newsRepo.getQueryData(query)
            emit(data)
        }
    }
}