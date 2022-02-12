package com.application.tastyapp.response.model.data.favdata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "FavRecipe")
class FavTable(
    @SerializedName("name")
    val name: String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("video_url")
    val videoUrl: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}