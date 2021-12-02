package com.application.itunessong.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.application.itunessong.responsemodel.Result

@Dao
interface SongDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSong(result: List<Result>)
}