package com.example.pizzaandroid.response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl("https://android.free.beeceptor.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    fun getApiService() = getRetrofit().create(ApiService::class.java)

}