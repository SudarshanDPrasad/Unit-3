package com.application.itunessong.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.application.itunessong.responsemodel.ResponseDTO
import com.application.itunessong.responsemodel.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class SongViewModel @Inject constructor(val songRepo: SongRepo) : ViewModel() {

    private val mutableLiveData = MutableLiveData<MainUiModel>()
    val liveData: LiveData<MainUiModel> = mutableLiveData

    fun getData(query: String): LiveData<Resource<ResponseDTO>> {
        return liveData(Dispatchers.IO) {
            val data = songRepo.getSong(query)
            emit(data)
        }
    }

//    fun getData(query: String) {
//        CoroutineScope(Dispatchers.IO).launch {
//            val repo = songRepo.getSong(query)
//            if (repo != null) {
//                mutableLiveData.postValue(MainUiModel.OnSuccess(repo))
//            }else{
//                mutableLiveData.postValue(MainUiModel.OnFailure("Error"))
//            }
//        }
//    }

    fun getAPi(result: List<Result>) {
        songRepo.getResponse(result)
    }
}