package com.example.pizzaandroid.response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
 // https://gist.githubusercontent.com/chekeAditya/30bb6e2f20558100fe5fcf4c04e91892/raw/f4fbe0fbb1b081834e790e30e15be531f858a527/Customizable%2520Pizza
    fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/chekeAditya/30bb6e2f20558100fe5fcf4c04e91892/raw/f4fbe0fbb1b081834e790e30e15be531f858a527/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    fun getApiService() = getRetrofit().create(ApiService::class.java)

}