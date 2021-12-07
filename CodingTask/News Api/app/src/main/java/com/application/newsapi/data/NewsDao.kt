package com.application.newsapi.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.application.newsapi.response.Article


@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun getData(newsTable: List<Article>)


    @Query("select * from article")
    fun getDb() : LiveData<List<Article>>

    @Query("delete from article")
    fun deletefromdb()
}