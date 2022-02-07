package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class UserRatings(
    @SerializedName("count_negative")
    val countNegative: Int,
    @SerializedName("count_positive")
    val countPositive: Int,
    @SerializedName("score")
    val score: Double
)