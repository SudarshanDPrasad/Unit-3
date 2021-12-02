package com.application.itunes2.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.application.itunessong.responsemodel.Result

@Dao
interface ItunesDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun getData(ituneTable: List<Result>)

    @Query("select * from result where artistName like :query")
    fun getDb(query:String) : LiveData<List<Result>>
}
