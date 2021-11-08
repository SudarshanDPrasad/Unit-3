package com.application.newsbreezeapp.api

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory



object NetworkHelper {

    private fun getNetworkInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiService.Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    fun getApiService(): ApiService = getNetworkInstance().create(ApiService::class.java)
}