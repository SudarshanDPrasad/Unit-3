package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class CreditX(
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String
)