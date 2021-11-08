package com.application.newsbreezeapp.ApiCall


import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)