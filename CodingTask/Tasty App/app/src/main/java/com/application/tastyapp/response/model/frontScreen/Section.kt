package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("components")
    val components: List<Component>,
    @SerializedName("name")
    val name: Any,
    @SerializedName("position")
    val position: Int
)