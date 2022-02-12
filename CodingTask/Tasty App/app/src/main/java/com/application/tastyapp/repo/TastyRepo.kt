package com.application.tastyapp.repo

import androidx.lifecycle.LiveData
import com.application.tastyapp.response.api.TastyApi
import com.application.tastyapp.response.model.data.favdata.FavDao
import com.application.tastyapp.response.model.data.favdata.FavTable
import com.application.tastyapp.response.model.data.logindata.LoginDao
import com.application.tastyapp.response.model.data.logindata.LoginTable
import com.application.tastyapp.response.model.frontScreen.ResultModel
import com.application.tastyapp.response.module.Resource
import com.application.tastyapp.response.module.ResponseHandler
import com.application.tastyapp.response.module.TastyModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TastyRepo @Inject constructor(
    val tastyApi: TastyApi,
    val loginDao: LoginDao,
    val favDao: FavDao,
) {


    val responseHandler: ResponseHandler = ResponseHandler()
    suspend fun getDetials(): Resource<List<ResultModel>> {
        return try {
            val data = TastyModule.ProvidesAPi().getDetails().resultModels
            responseHandler.handleSuccess(data)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun addLogin(loginTable: LoginTable) {
        CoroutineScope(Dispatchers.IO).launch {
            loginDao.getData(loginTable)
        }
    }

    fun addData(favTable: FavTable) {
        CoroutineScope(Dispatchers.IO).launch {
            favDao.addData(favTable)
        }
    }

    fun getData(): LiveData<List<FavTable>> {
        return favDao.getData()
    }
}