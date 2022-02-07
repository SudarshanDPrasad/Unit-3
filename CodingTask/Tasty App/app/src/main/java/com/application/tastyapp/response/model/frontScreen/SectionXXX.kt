package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class SectionXXX(
    @SerializedName("components")
    val components: List<ComponentXXX>,
    @SerializedName("name")
    val name: Any,
    @SerializedName("position")
    val position: Int
)