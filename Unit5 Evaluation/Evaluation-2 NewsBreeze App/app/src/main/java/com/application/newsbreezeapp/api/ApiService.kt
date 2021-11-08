package com.application.newsbreezeapp.api

import com.application.newsbreezeapp.ApiCall.ResponseModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiService {

    companion object {
        val Base_Url = " https://newsapi.org/"

    }

    @GET("v2/everything?q=tesla&from=2021-10-08&sortBy=publishedAt&apiKey=ab424053c14248b6bbb7da59fa401cfd")
    fun getDeatils(): Observable<ResponseModel>
}