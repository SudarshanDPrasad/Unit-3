package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class MeasurementX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("quantity")
    val quantity: String,
    @SerializedName("unit")
    val unit: UnitX
)