package com.application.indianews.reponse


import com.google.gson.annotations.SerializedName

data class ResponseDTO(
    @SerializedName("category")
    val category: String,
    @SerializedName("count-articles")
    val countArticles: Int,
    @SerializedName("data")
    val `data`: List<Data>
)