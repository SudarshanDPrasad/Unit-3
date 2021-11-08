package com.application.newsbreezeapp.api

import com.application.newsbreezeapp.apicall.remote.ResponseDTOX
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiService {

    companion object {
        val Base_Url = "https://newsapi.org/"

    }

    @GET("v2/top-headlines?country=us&category=business&apiKey=ab424053c14248b6bbb7da59fa401cfd")
    fun getDeatils(): Observable<ResponseDTOX>
}