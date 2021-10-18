package com.example.evaluation1.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl(" https://api.tvmaze.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    fun getApiService() = getRetrofit().create(ApiClient::class.java)
}