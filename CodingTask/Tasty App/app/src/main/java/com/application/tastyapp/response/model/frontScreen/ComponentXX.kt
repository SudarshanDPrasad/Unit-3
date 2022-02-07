package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class ComponentXX(
    @SerializedName("extra_comment")
    val extraComment: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("ingredient")
    val ingredient: IngredientXX,
    @SerializedName("linked_recipe")
    val linkedRecipe: LinkedRecipe,
    @SerializedName("measurements")
    val measurements: List<MeasurementXX>,
    @SerializedName("position")
    val position: Int,
    @SerializedName("raw_text")
    val rawText: String
)