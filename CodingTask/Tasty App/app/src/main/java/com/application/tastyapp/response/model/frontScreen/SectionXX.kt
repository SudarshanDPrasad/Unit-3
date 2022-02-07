package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class SectionXX(
    @SerializedName("components")
    val components: List<ComponentXX>,
    @SerializedName("name")
    val name: Any,
    @SerializedName("position")
    val position: Int
)