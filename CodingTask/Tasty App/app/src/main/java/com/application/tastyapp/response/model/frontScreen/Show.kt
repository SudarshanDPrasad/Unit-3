package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class Show(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)