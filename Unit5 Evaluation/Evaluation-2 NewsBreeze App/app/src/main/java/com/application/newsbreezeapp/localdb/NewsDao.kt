package com.application.newsbreezeapp.localdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.application.newsbreezeapp.apicall.remote.Article

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addData(article: List<Article>)
}