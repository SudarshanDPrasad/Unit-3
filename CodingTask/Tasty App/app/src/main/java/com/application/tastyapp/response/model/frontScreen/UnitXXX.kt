package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class UnitXXX(
    @SerializedName("abbreviation")
    val abbreviation: String,
    @SerializedName("display_plural")
    val displayPlural: String,
    @SerializedName("display_singular")
    val displaySingular: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("system")
    val system: String
)