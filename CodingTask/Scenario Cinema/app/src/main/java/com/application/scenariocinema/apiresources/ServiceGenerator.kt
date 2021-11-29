package com.application.scenariocinema.apiresources

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    private fun getNetworkInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiMovie.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    fun getApiService(): ApiMovie = getNetworkInstance().create(ApiMovie::class.java)
}