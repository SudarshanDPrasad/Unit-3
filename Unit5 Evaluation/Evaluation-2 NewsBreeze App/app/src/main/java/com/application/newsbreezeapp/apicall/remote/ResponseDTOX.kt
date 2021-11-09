package com.application.newsbreezeapp.apicall.remote


import com.google.gson.annotations.SerializedName

data class ResponseDTOX(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)