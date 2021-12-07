package com.application.contactreadapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Contacts")
data class ContactTable(
    @ColumnInfo(name = "Name") var Name: String,
    @ColumnInfo(name = "Number") var Number: String,
    @ColumnInfo(name = "Contact_count") var contactcount: Int,
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}