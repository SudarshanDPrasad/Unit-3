package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("category")
    val category: String,
    @SerializedName("item")
    val item: Item,
    @SerializedName("items")
    val items: List<ItemX>,
    @SerializedName("min_items")
    val minItems: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String
)