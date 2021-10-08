package com.example.recyclerdatabinding.response

import com.example.databindingapi.response.Response_DTO
import retrofit2.Call
import retrofit2.http.GET

interface ApiCLinet {
    @GET("v3/0404dd7e-c1ba-4669-b14b-3331f46741ec")
    fun getAPIResponse(): Call<Response_DTO>
}