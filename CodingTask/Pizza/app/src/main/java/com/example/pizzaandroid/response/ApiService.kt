package com.example.pizzaandroid.response

import retrofit2.http.GET

interface ApiService {

    @GET("Customizable%2520Pizza")
    suspend fun getcartfromapi() : Response_Model

    @GET("Customizable%2520Pizza")
    suspend fun getcartcrust() : Crust

}