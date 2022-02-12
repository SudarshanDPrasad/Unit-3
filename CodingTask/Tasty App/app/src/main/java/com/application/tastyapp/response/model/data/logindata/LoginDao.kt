package com.application.tastyapp.response.model.data.logindata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.application.tastyapp.response.model.frontScreen.ItemX


@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun getData(loginTable: LoginTable)

}