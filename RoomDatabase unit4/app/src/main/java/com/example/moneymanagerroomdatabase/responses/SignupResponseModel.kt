package com.example.moneymanagerroomdatabase.responses


import com.google.gson.annotations.SerializedName

data class SignupResponseModel(
    @SerializedName("token")
    val token: String,
    @SerializedName("user")
    val user: UserX
)