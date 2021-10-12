package com.example.recyclerdatabinding.response

import com.example.databindingmvvm.response.Responsemodel
import com.example.databindingmvvm.response.indiantoonresponse
import retrofit2.http.GET

//https://run.mocky.io/v3/0404dd7e-c1ba-4669-b14b-3331f46741ec
interface ApiCLinet {
    @GET("v3/0404dd7e-c1ba-4669-b14b-3331f46741ec")
   suspend fun getAPIResponse(): indiantoonresponse
}