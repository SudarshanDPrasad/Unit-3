package com.example.roomdatabase.models.responses


import com.google.gson.annotations.SerializedName

data class CreateTaskRequestModel(
    @SerializedName("description")
    val description: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("title")
    val title: String
)