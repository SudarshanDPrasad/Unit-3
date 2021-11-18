package com.application.moneymanager.dataexpenses

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.application.moneymanager.data.ExpensesTable
import com.application.moneymanager.data.IncomeDao
import com.application.moneymanager.data.IncomeRoomDataBase
import com.application.moneymanager.data.IncomeTable

@Database(entities = [ExpensesTable::class], version = 2)
abstract class ExpenesesRoomDataBase : RoomDatabase() {

    abstract fun getFeedbackDao(): ExpensesDao

    companion object {
        private var INSTANCE: ExpenesesRoomDataBase? = null

        fun getDataBaseObject(context: Context): ExpenesesRoomDataBase {
            if (INSTANCE == null) {

                var builder = Room.databaseBuilder(context.applicationContext,
                    ExpenesesRoomDataBase::class.java,
                    "Expenses")
                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }
    }
}