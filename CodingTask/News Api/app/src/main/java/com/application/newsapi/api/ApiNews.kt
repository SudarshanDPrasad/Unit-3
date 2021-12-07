package com.application.newsapi.api

import com.application.newsapi.response.ResponseDTO
import retrofit2.http.GET

interface ApiNews {

    @GET("v2/everything?domains=wsj.com&apiKey=ab424053c14248b6bbb7da59fa401cfd")
    suspend fun getApi(): ResponseDTO
}