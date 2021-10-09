package com.example.pizzaandroid.response

import retrofit2.http.GET

interface ApiService {

    @GET("pizzas")
    suspend fun getcartfromapi() : Response_Model

    @GET("pizzas")
    suspend fun getcartfromapicrust() : Crust
}