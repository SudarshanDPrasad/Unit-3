package com.application.newsbreezeapp.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [NewsTable::class], version = 1)
abstract class NewsRoomDataBase : RoomDatabase() {

    abstract fun getNewsDao() : NewsDao

    companion object {
        private var INSTANCE: NewsRoomDataBase? = null

        fun getDataBaseObject(context: Context): NewsRoomDataBase {
            if (INSTANCE == null) {

                var builder = Room.databaseBuilder(context.applicationContext,
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