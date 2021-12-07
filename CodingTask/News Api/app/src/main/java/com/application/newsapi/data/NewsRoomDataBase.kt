package com.application.newsapi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.application.newsapi.response.Article

@Database(entities = [NewsTable::class,Article::class],version = 3)
abstract class NewsRoomDataBase : RoomDatabase() {

    abstract fun getDao(): NewsDao

    companion object {
        private var INSTANCE: NewsRoomDataBase? = null

        fun getDataBaseObject(context: Context): NewsRoomDataBase {
            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(context.applicationContext,
                    NewsRoomDataBase::class.java,
                    "News_db")
                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }
    }
}