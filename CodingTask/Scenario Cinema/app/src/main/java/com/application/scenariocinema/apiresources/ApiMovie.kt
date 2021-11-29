package com.application.scenariocinema.apiresources

import com.application.scenariocinema.responseonemore.MovieResponse2
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ApiMovie {

    companion object {
        val BASE_URL = "http://api.themoviedb.org/3/"
    }

    @GET("movie/popular?api_key=23e22ddba5c8cb112a8613486167f192&")
    suspend fun getDetails(
        @Query("release_date") release_date
        : String,
        @Query("page") Page: Int,

        ): MovieResponse2

}