package com.example.evaluation1.api

import com.example.evaluation1.response.ResponseModel
import retrofit2.http.GET

interface ApiClient {

    @GET("people")
    suspend fun getResponse() : ResponseModel
}

