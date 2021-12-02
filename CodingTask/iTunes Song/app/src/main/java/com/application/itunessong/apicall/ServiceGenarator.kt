package com.application.itunessong.apicall

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenarator {

    fun getRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getApiService(): ApiSong = getRetrofit().create(ApiSong::class.java)

}