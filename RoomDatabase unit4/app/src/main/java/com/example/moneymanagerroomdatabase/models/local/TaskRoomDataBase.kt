package com.example.moneymanagerroomdatabase.models.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TaskIncome::class, TaskExpenses::class], version = 5)
abstract class TaskRoomDataBase : RoomDatabase() {


    abstract fun getTaskDAO(): TaskDAO

    companion object {
        private var INSTANCE: TaskRoomDataBase? = null

        fun getDataBaseObject(context: Context): TaskRoomDataBase {
            if (INSTANCE == null) {

                var builder = Room.databaseBuilder(context.applicationContext,
                    TaskRoomDataBase::class.java,
                    "task_db")
                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }
    }


}