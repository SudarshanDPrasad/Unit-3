package com.application.itunessong.apicall

import com.application.itunessong.responsemodel.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSong {


    @GET("search")
    suspend fun getDetails(@Query("term") term: String) : ResponseDTO
}