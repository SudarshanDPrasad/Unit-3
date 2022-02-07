package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class Topic(
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)