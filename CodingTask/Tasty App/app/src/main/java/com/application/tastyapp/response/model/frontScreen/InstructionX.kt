package com.application.tastyapp.response.model.frontScreen


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable



data class InstructionX(
    @SerializedName("appliance")
    val appliance: String,
    @SerializedName("display_text")
    val displayText: String,
    @SerializedName("end_time")
    val endTime: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("position")
    val position: Int,
    @SerializedName("start_time")
    val startTime: Int,
    @SerializedName("temperature")
    val temperature: Int
) : Serializable