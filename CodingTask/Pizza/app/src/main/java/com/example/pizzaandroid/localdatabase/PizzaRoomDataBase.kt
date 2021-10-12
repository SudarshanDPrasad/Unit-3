package com.example.pizzaandroid.localdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pizzaandroid.DataModel.CartData

@Database(entities = [CartData::class], version = 1)
abstract class PizzaRoomDataBase :RoomDatabase(){

    abstract fun getTaskDAO(): Dao

    companion object {
        private var INSTANCE: PizzaRoomDataBase? = null

        fun getDataBaseObject(context: Context): PizzaRoomDataBase {
            if (INSTANCE == null) {

                var builder = Room.databaseBuilder(context.applicationContext,
                    PizzaRoomDataBase::class.java,
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