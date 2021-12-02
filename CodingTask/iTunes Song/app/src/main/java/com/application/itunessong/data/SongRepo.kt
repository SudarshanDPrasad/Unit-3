package com.application.itunessong.data

import com.application.itunessong.apicall.ApiSong
import com.application.itunessong.apicall.ServiceGenarator
import com.application.itunessong.responsemodel.ResponseDTO
import com.application.itunessong.responsemodel.Result
import com.application.itunessong.roomdatabase.SongDao
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject


class SongRepo @Inject constructor(val songDao: SongDao) {

    val responseHandler: ResponseHandler = ResponseHandler()
    private var apiClient: ApiSong = ServiceGenarator.getApiService()


    suspend fun getSong(query: String): Resource<ResponseDTO> {
        return try {
            val response = ServiceGenarator.getApiService().getDetails(query)
            responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

//    suspend fun getSong(query: String): ResponseDTO {
//        return ServiceGenarator.getApiService().getDetails(query)
//    }


    fun getResponse(result: List<Result>) {
        val listOfData = ArrayList<Result>()
        listOfData.addAll(result)

        songDao.addSong(listOfData)
    }
}