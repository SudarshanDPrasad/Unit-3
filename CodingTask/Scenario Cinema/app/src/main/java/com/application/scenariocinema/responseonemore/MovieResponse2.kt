package com.application.scenariocinema.responseonemore


import com.google.gson.annotations.SerializedName

data class MovieResponse2(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)