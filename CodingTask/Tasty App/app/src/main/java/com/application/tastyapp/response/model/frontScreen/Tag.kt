package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("display_name")
    val displayName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String
)