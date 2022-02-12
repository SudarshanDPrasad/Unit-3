package com.application.tastyapp.response.model.data.favdata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface FavDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addData(favTable: FavTable)

    @Query("select * from FavRecipe ")
    fun getData() : LiveData<List<FavTable>>
}