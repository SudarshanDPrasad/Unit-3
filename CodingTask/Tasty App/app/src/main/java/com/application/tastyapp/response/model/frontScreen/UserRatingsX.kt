package com.application.tastyapp.response.model.frontScreen


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class UserRatingsX(
    @SerializedName("count_negative")
    val countNegative: Int,
    @SerializedName("count_positive")
    val countPositive: Int,
    @SerializedName("score")
    val score: Double
) : Serializable