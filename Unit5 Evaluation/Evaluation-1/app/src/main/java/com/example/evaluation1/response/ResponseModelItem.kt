package com.example.evaluation1.response


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class ResponseModelItem(
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("country")
    val country: Country,
    @SerializedName("deathday")
    val deathday: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: Image,
    @SerializedName("_links")
    val links: Links,
    @SerializedName("name")
    val name: String,
    @SerializedName("updated")
    val updated: Int,
    @SerializedName("url")
    val url: String
)