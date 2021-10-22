package com.example.rxjavarecyclerview.api

import com.example.pagination_recyclerview.response.Response_Model
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {

        val BASE_URL = "https://api.themoviedb.org/3/"
    }

    @GET("movie/popular?api_key=23e22ddba5c8cb112a8613486167f192&")
    fun getAllDetails(@Query("page") Page: Int): Observable<Response_Model>
}