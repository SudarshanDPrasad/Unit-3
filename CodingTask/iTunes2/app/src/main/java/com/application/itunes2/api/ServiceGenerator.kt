package com.application.itunes2.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    fun getRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getApiResponse(): ApiCall = getRetrofit().create(ApiCall::class.java)

}