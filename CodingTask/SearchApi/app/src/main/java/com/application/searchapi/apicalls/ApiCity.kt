package com.application.searchapi.apicalls

import android.location.Address
import com.application.searchapi.response.Data
import com.application.searchapi.response.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCity {

    @GET("compassLocation/rest/address/autocomplete")
    suspend fun getCityName(
        @Query("queryString") queryString: String,
        @Query("city") city: String,
    ): ResponseDTO
}