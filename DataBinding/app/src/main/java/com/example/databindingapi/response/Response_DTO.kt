package com.example.databindingapi.response


import com.google.gson.annotations.SerializedName

data class Response_DTO(
    @SerializedName("Indian Toons")
    val indianToons: List<IndianToon>
)