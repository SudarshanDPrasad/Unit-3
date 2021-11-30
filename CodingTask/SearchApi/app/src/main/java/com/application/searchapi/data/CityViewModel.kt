package com.application.searchapi.data

import android.location.Address
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.application.searchapi.response.Data
import com.application.searchapi.response.ResponseDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CityViewModel @Inject constructor() : ViewModel() {

    private val cityRepo = CityRepo()
    private val mutableLiveData = MutableLiveData<MainUiModel>()
    val liveData: LiveData<MainUiModel> = mutableLiveData


//    LiveData<Resource<com.application.searchapi.response.Data>>


    fun getData(query: String) : LiveData<Resource<ResponseDTO>>{

//        CoroutineScope(Dispatchers.IO).launch {
//            val repo = cityRepo.getAllCities(query)
//            if (repo != null) {
//                mutableLiveData.postValue(MainUiModel.OnSuccess(repo))
//            } else {
//                mutableLiveData.postValue(MainUiModel.OnFailure("Error"))
//            }
//       }



        return liveData(Dispatchers.IO) {
            val data = cityRepo.getAllCities(query)
            emit(data)
        }
    }
}