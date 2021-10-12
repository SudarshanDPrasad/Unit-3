package com.example.databindingmvvm.response


import com.google.gson.annotations.SerializedName

data class IndianToon(
    @SerializedName("description")
    val description: String,
    @SerializedName("Director")
    val director: String,
    @SerializedName("DirectorImage")
    val directorImage: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("Language")
    val language: String,
    @SerializedName("MovieName")
    val movieName: String,
    @SerializedName("MovieTrailerLink")
    val movieTrailerLink: String,
    @SerializedName("Rating")
    val rating: String,
    @SerializedName("Timing")
    val timing: String,
    @SerializedName("Year")
    val year: String
)