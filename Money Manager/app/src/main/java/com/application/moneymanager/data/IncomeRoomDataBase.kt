package com.application.moneymanager.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [IncomeTable::class], version = 3)
abstract class IncomeRoomDataBase : RoomDatabase() {


    abstract fun getFeedbackDao(): IncomeDao

    companion object {
        private var INSTANCE: IncomeRoomDataBase? = null

        fun getDataBaseObject(context: Context): IncomeRoomDataBase {
            if (INSTANCE == null) {

                var builder = Room.databaseBuilder(context.applicationContext,
                    IncomeRoomDataBase::class.java,
                    "Income")
                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }
    }


}