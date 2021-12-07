package com.application.indianews.api

import com.application.indianews.reponse.ResponseDTO
import retrofit2.http.GET

interface ApiNews {

    @GET("sports")
    suspend fun getSports() : ResponseDTO

    @GET("automobile")
    suspend fun getAutoMobile() : ResponseDTO

    @GET("business")
    suspend fun getBusiness() : ResponseDTO

    @GET("entertainment")
    suspend fun getEntertainment() : ResponseDTO

    @GET("technology")
    suspend fun getTechnology() : ResponseDTO
}