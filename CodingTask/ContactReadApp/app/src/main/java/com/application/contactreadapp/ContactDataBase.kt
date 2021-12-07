package com.application.contactreadapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ContactTable::class], version = 2)
abstract class ContactDataBase : RoomDatabase() {

    abstract fun contactdao(): ContactDao

    companion object {
        @Volatile
        private var INSTANCE: ContactDataBase? = null

        fun getDataBaseObject(context: Context): ContactDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: builDataBase(context)
            }


        private fun builDataBase(context: Context) : ContactDataBase =
            Room.databaseBuilder(context.applicationContext,
                ContactDataBase::class.java,
                "Contacts")
                .build()

    }
}