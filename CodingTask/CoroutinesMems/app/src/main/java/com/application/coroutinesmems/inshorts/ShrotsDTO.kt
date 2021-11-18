package com.application.coroutinesmems.inshorts


import com.google.gson.annotations.SerializedName

data class ShrotsDTO(
    @SerializedName("category")
    val category: String,
    @SerializedName("count-articles")
    val countArticles: Int,
    @SerializedName("data")
    val `data`: List<Data>
)