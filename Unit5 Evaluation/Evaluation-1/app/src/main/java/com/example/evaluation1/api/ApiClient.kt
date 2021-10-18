package com.example.evaluation1.api

import com.example.evaluation1.response.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("people")
    suspend fun getResponse(@Query("page") page: Int): ResponseModel
}

