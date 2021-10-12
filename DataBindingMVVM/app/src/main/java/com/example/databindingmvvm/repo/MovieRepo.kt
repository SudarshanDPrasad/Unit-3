package com.example.databindingmvvm.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.databindingmvvm.response.IndianToon
import com.example.databindingmvvm.response.Result
import com.example.recyclerdatabinding.response.ApiCLinet
import kotlinx.coroutines.Dispatchers

class MovieRepo(val apiCLinet: ApiCLinet) {


   fun getmoviedetails(): LiveData<List<IndianToon>> {
        return liveData(Dispatchers.IO) {
             val response1 = apiCLinet.getAPIResponse().indianToons
            emit(response1)
        }
    }
}