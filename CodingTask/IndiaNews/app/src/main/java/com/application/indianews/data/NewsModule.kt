package com.application.indianews.data

import com.application.indianews.api.ApiNews
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NewsModule {

    @Singleton
    @Provides
    fun ProvidesApi(): ApiNews {
        val builder = Retrofit.Builder()
            .baseUrl(" https://inshorts-news.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return builder.create(ApiNews::class.java)
    }


}