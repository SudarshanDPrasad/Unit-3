package com.application.tastyapp.response.model.data.logindata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Login Table")
data class LoginTable(
    @ColumnInfo(name = "UserName") var userName: String,
    @ColumnInfo(name = "Password") var password: String,
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}