package com.application.tastyapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.application.tastyapp.repo.TastyRepo
import com.application.tastyapp.response.model.frontScreen.ItemX
import com.application.tastyapp.response.model.frontScreen.ResponseDto
import com.application.tastyapp.response.model.frontScreen.ResultModel
import com.application.tastyapp.response.module.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


@HiltViewModel
class TastyViewModel @Inject constructor(val tastyRepo: TastyRepo): ViewModel() {

//    private var tastyRepo = TastyRepo()

    fun getData(): LiveData<Resource<List<ResultModel>>> {
        return liveData(Dispatchers.IO) {
            val data = tastyRepo.getDetials()
            emit(data)
        }
    }

}