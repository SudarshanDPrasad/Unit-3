package com.application.tastyapp.response.model.data.favdata

import android.content.Context
import androidx.room.*


@Database(entities = [FavTable::class], version = 5)

abstract class FavRoomDataBase : RoomDatabase() {

    abstract fun getDaoFav(): FavDao

    companion object {
        private var INSTANCE: FavRoomDataBase? = null

        fun getDataBaseObjectFav(context: Context): FavRoomDataBase {
            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(context.applicationContext,
                    FavRoomDataBase::class.java,
                    "List")
                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }
    }
}
