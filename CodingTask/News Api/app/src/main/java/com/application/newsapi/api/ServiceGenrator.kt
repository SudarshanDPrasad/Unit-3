package com.application.newsapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenrator {

    fun getRetorfit() =
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getApiService(): ApiNews = getRetorfit().create(ApiNews::class.java)
}