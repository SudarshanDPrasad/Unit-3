package com.example.recyclerdatabinding.network

import com.example.recyclerdatabinding.response.ApiCLinet
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object Network {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    @Provides
    fun provideAPIService():ApiCLinet{
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(ApiCLinet::class.java)
    }
}