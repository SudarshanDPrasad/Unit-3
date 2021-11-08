package com.application.newsbreezeapp.localdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "News Feed")
class RoomDataBase(
    @ColumnInfo(name = "Date") var date: String,
    @ColumnInfo(name = "Title") var title: String,
) {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = null
}