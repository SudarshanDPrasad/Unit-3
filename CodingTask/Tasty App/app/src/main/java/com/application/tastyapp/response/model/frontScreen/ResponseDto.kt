package com.application.tastyapp.response.model.frontScreen


import com.google.gson.annotations.SerializedName

data class ResponseDto(
    @SerializedName("results")
    val resultModels: List<ResultModel>
)