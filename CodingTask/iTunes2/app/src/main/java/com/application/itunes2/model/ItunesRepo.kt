package com.application.itunes2.model

import androidx.lifecycle.LiveData
import com.application.itunes2.api.ServiceGenerator
import com.application.itunes2.data.ItunesDao
import com.application.itunessong.responsemodel.ResponseDTO
import com.application.itunessong.responsemodel.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


class ItunesRepo @Inject constructor(var itunesDao: ItunesDao) {

    val responseHandler: ResponseHandler = ResponseHandler()

    suspend fun getApiCall(query: String): Resource<ResponseDTO> {
        return try {
            val response = ServiceGenerator.getApiResponse().getDetails(query)
            responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun addtoDB(ituneTable: List<Result>) {
        CoroutineScope(Dispatchers.IO).launch {
            itunesDao.getData(ituneTable)
        }
    }

    fun getSongs(query:String): LiveData<List<Result>> {
        return itunesDao.getDb(query)
    }
}