package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class TotalTimeTierX(
    @SerializedName("display_tier")
    val displayTier: String,
    @SerializedName("tier")
    val tier: String
)