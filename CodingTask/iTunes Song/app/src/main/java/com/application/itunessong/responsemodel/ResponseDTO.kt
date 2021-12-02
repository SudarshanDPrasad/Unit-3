package com.application.itunessong.responsemodel


import com.google.gson.annotations.SerializedName

data class ResponseDTO(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val result: List<Result>
)