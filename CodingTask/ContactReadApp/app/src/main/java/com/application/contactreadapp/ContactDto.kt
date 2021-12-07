package com.application.contactreadapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ContactDto {

    var name = ""
    var number = ""

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int? = null
}