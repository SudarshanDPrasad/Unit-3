package com.example.recyclerdatabinding.response

import com.example.databindingmvvm.response.Responsemodel
import retrofit2.http.GET

interface ApiCLinet {
    @GET("movie/popular/?api_key=2147294b386ecadcb05cd19bcbbdddb9")
   suspend fun getAPIResponse(): Responsemodel
}