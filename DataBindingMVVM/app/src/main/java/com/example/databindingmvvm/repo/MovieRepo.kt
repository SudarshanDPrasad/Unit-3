package com.example.databindingmvvm.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.databindingmvvm.response.Result
import com.example.recyclerdatabinding.response.ApiCLinet
import kotlinx.coroutines.Dispatchers

class MovieRepo(val apiCLinet: ApiCLinet) {


   fun getmoviedetails(): LiveData<List<Result>> {
        return liveData(Dispatchers.IO) {
             val response1 = apiCLinet.getAPIResponse().results
            emit(response1)
        }
    }
}