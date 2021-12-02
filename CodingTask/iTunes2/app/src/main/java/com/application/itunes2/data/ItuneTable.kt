package com.application.itunes2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Song_Table")
data class ItuneTable(
    @ColumnInfo(name = "Song_Name") var song_name: String,
    @ColumnInfo(name = "Artist_Name") var artist_name: String,
    @ColumnInfo(name = "Urlname") var urlname: String,
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}