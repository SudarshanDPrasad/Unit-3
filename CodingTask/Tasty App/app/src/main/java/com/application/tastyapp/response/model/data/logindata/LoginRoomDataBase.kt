package com.application.tastyapp.response.model.data.logindata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LoginTable::class], version = 3)
abstract class LoginRoomDataBase : RoomDatabase() {

    abstract fun getDao(): LoginDao

    companion object {
        private var INSTANCE: LoginRoomDataBase? = null

        fun getDataBaseObject(context: Context): LoginRoomDataBase {
            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(context.applicationContext,
                    LoginRoomDataBase::class.java,
                    "login")
                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }
    }
}
