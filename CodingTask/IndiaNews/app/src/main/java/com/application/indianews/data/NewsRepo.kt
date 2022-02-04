package com.application.indianews.data

import com.application.indianews.reponse.ResponseDTO
import retrofit2.http.Query

class NewsRepo {

    val responseHandler = ResponseHandler()
    suspend fun getSportsData(): Resource<ResponseDTO> {
        return try {
            val response = NewsModule.ProvidesApi().getSports()
            responseHandler.handleSuccess(response)
        } catch (e: Exception){
            responseHandler.handleException(e)
        }
    }

    suspend fun getAutoMobileData(): Resource<ResponseDTO> {
        return try {
            val response = NewsModule.ProvidesApi().getAutoMobile()
            responseHandler.handleSuccess(response)
        } catch (e: Exception){
            responseHandler.handleException(e)
        }
    }

    suspend fun getBusinessData(): Resource<ResponseDTO> {
        return try {
            val response = NewsModule.ProvidesApi().getBusiness()
            responseHandler.handleSuccess(response)
        } catch (e: Exception){
            responseHandler.handleException(e)
        }
    }

    suspend fun getEntertainmentData(): Resource<ResponseDTO> {
        return try {
            val response = NewsModule.ProvidesApi().getEntertainment()
            responseHandler.handleSuccess(response)
        } catch (e: Exception){
            responseHandler.handleException(e)
        }
    }

    suspend fun getTechnologyData(): Resource<ResponseDTO> {
        return try {
            val response = NewsModule.ProvidesApi().getTechnology()
            responseHandler.handleSuccess(response)
        } catch (e: Exception){
            responseHandler.handleException(e)
        }
    }

    suspend fun getNationalData(): Resource<ResponseDTO> {
        return try {
            val response = NewsModule.ProvidesApi().getNational()
            responseHandler.handleSuccess(response)
        } catch (e: Exception){
            responseHandler.handleException(e)
        }
    }

    suspend fun getQueryData(query: String): Resource<ResponseDTO> {
        return try {
            val response = NewsModule.ProvidesApi().getQuery(query)
            responseHandler.handleSuccess(response)
        } catch (e: Exception){
            responseHandler.handleException(e)
        }
    }
}