package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class Credit(
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String
)