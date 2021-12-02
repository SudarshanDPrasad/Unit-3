package com.application.itunes2.api

import com.application.itunessong.responsemodel.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {

    @GET("search")
    suspend fun getDetails(@Query("term") term: String) : ResponseDTO
}