package com.application.tastyapp.response.api

import com.application.tastyapp.response.model.frontScreen.ResponseDto
import com.application.tastyapp.response.model.frontScreen.ResultModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TastyApi {

    @GET("feeds/list?size=20&timezone=%2B0700&vegetarian=false&from=0")
    suspend fun getDetails(
        @Header("x-rapidapi-host") host: String = "tasty.p.rapidapi.com",
        @Header("x-rapidapi-key") key: String = "998ec3f38emshaa89ba9899ff9dbp18bd59jsn3db88f98541e",
    ) : ResponseDto
}