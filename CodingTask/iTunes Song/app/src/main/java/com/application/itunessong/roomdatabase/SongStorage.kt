package com.application.itunessong.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Song_Search")
data class SongStorage(
    @ColumnInfo(name = "Song Name") var Song_Name: String,
    @ColumnInfo(name = "Song Artist") var Song_Artist: String,
    @ColumnInfo(name = "Song_Url") var Song_Url: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}