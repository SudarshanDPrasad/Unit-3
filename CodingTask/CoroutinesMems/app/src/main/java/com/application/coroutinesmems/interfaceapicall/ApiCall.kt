package com.application.coroutinesmems.interfaceapicall

import com.application.coroutinesmems.apiresponse.Data
import com.application.coroutinesmems.apiresponse.ResponseDTO
import retrofit2.http.GET

interface ApiCall {


    @GET("/get_memes")
    suspend fun getMemes() : ResponseDTO

}