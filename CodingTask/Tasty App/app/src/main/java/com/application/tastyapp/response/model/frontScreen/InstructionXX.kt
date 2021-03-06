package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class InstructionXX(
    @SerializedName("appliance")
    val appliance: Any,
    @SerializedName("display_text")
    val displayText: String,
    @SerializedName("end_time")
    val endTime: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("position")
    val position: Int,
    @SerializedName("start_time")
    val startTime: Int,
    @SerializedName("temperature")
    val temperature: Any
)