package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class ComponentXXX(
    @SerializedName("extra_comment")
    val extraComment: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("ingredient")
    val ingredient: IngredientXXX,
    @SerializedName("measurements")
    val measurements: List<MeasurementXXX>,
    @SerializedName("position")
    val position: Int,
    @SerializedName("raw_text")
    val rawText: String
)