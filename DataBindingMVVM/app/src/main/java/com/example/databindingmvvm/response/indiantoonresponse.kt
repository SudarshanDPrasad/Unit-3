package com.example.databindingmvvm.response


import com.google.gson.annotations.SerializedName

data class indiantoonresponse(
    @SerializedName("Indian Toons")
    val indianToons: List<IndianToon>
)