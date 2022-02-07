package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class AnalyticsMetadata(
    @SerializedName("data_source")
    val dataSource: String
)