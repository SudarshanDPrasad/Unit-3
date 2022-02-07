package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class CreditXX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("type")
    val type: String
)