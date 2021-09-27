package com.example.moneymanagerroomdatabase.responses


import com.google.gson.annotations.SerializedName

data class SignupRequestModel(
    @SerializedName("age")
    val age: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String
)