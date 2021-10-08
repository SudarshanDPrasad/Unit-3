package com.example.recyclerdatabinding.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.recyclerdatabinding.response.ApiCLinet
import com.example.recyclerdatabinding.response.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class movieRepo @Inject constructor(private val apiCLinet: ApiCLinet) {

    fun getMovieList() : LiveData<List<Result>> {
       return liveData(Dispatchers.IO) {
          apiCLinet.getAPIResponse().results
       }
    }
}