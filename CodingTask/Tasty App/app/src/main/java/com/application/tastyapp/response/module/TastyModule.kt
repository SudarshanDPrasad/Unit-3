package com.application.tastyapp.response.module

import com.application.tastyapp.response.api.TastyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TastyModule {

    @Singleton
    @Provides
    fun ProvidesAPi(): TastyApi {
        val builder = Retrofit.Builder()
            .baseUrl("https://tasty.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return builder.create(TastyApi::class.java)
    }
}