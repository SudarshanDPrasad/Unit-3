package com.application.searchapi.data

import android.location.Address
import com.application.searchapi.apicalls.ServiceGenerator
import com.application.searchapi.response.Data
import com.application.searchapi.response.ResponseDTO
import javax.inject.Inject

class CityRepo() {

    val responseModel : ResponseHandler = ResponseHandler()

//    suspend fun getAllCities(query:String): ResponseDTO {
//        return ServiceGenerator.getApiService().getCityName("airtel",query)
//    }

    suspend fun getAllCities(query:String): Resource<ResponseDTO> {
        return try {
            val response : ResponseDTO = ServiceGenerator.getApiService().getCityName("airtel",query)

            responseModel.handleSuccess(response)
        }catch (e : Exception){
            responseModel.handleException(e)
        }
    }
}