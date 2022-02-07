package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class TotalTimeTier(
    @SerializedName("display_tier")
    val displayTier: String,
    @SerializedName("tier")
    val tier: String
)