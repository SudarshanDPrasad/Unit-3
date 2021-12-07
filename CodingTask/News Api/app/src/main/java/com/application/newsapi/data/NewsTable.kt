package com.application.newsapi.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "News_Table")
data class NewsTable(
    @ColumnInfo(name = "Tittle") val Tittle: String,
    @ColumnInfo(name = "Author") val Author: String,

) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}