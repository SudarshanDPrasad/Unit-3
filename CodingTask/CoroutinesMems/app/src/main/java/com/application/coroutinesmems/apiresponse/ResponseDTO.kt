package com.application.coroutinesmems.apiresponse


import com.google.gson.annotations.SerializedName

data class ResponseDTO(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean
)