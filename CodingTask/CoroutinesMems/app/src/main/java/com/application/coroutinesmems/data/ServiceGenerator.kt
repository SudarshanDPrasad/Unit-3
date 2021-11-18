package com.application.coroutinesmems.data

import com.application.coroutinesmems.interfaceapicall.ApiCall
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl("https://api.imgflip.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getApiServices() = getRetrofit().create(ApiCall::class.java)

}