package com.example.pizzaandroid.response


import com.google.gson.annotations.SerializedName

data class Size(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double
)