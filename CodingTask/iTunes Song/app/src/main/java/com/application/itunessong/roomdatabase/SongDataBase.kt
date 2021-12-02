package com.application.itunessong.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [SongStorage::class], version = 1)
abstract class SongDataBase : RoomDatabase() {

    abstract fun getSongDao(): SongDao

    companion object {
        private var INSTANCE: SongDataBase? = null

        fun getDataBaseObject(context: Context): SongDataBase {
            if (INSTANCE == null) {

                var builder = Room.databaseBuilder(context.applicationContext,
                    SongDataBase::class.java,
                    "song_db")
                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }
    }
}