package com.example.evaluation1.response


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("self")
    val self: Self
)