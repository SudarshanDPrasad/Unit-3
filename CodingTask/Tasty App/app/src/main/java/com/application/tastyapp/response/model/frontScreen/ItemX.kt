package com.application.tastyapp.response.model.frontScreen

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable



data class ItemX(

    @SerializedName("instructions")
    val instructions: List<InstructionX>,
    @SerializedName("name")
    val name: String,
    @SerializedName("nutrition")
    val nutrition: NutritionX,
    @SerializedName("user_ratings")
    val userRatings: UserRatingsX,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("video_url")
    val videoUrl: String,

) : Serializable