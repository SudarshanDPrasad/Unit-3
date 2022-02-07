package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class ShowXXX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)