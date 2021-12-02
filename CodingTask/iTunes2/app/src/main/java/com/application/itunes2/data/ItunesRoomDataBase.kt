package com.application.itunes2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.application.itunessong.responsemodel.Result

@Database(entities = [ItuneTable::class,Result::class], version = 3)
abstract class ItunesRoomDataBase : RoomDatabase() {

    abstract fun getDao(): ItunesDao

    companion object {
        private var INSTANCE: ItunesRoomDataBase? = null

        fun getDataBaseObject(context: Context): ItunesRoomDataBase {
            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(context.applicationContext,
                    ItunesRoomDataBase::class.java,
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
