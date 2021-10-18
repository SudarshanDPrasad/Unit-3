package com.example.evaluation1.localdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.evaluation1.data.PersonTable

@Database(entities = [PersonTable::class], version = 1)
abstract class PersonDatabase : RoomDatabase(){

    abstract fun getTaskDAO(): PersonDao

    companion object {
        private var INSTANCE: PersonDatabase? = null

        fun getDataBaseObject(context: Context): PersonDatabase {
            if (INSTANCE == null) {

                var builder = Room.databaseBuilder(context.applicationContext,
                    PersonDatabase::class.java,
                    "pizza_db")
                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }
    }
}