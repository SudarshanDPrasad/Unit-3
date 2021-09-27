package com.example.moneymanagerroomdatabase.models.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moneymanagerroomdatabase.models.local.TaskExpenses
import com.example.moneymanagerroomdatabase.models.local.TaskIncome


@Dao
interface TaskDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //Replace the item
    fun addTaskincome(task: TaskIncome)


    @Query("select * from tasksincome")
    fun getAllTaskincome() : LiveData<List<TaskIncome>>

    @Query("select SUM(amount) as TOTAL from tasksincome")
    fun getAllIncome() : LiveData<Double>

    @Update
    fun updateTaskincome(task: TaskIncome)

    @Delete
    fun deleteTaskincome(task: TaskIncome)


    @Insert(onConflict = OnConflictStrategy.REPLACE) //Replace the item
    fun addTaskexpenses(task: TaskExpenses)

    @Query("select * from tasksexpenes")
    fun getAllTaskexpense() : LiveData<List<TaskExpenses>>

    @Query("select SUM(amount) as TOTAL from tasksexpenes")
    fun getAllExpenses() : LiveData<Double>

    @Update
    fun updateTaskexpenses(task: TaskExpenses)

    @Delete
    fun deleteTaskexpenses(task: TaskExpenses)

    @Query("delete from tasksincome")
    fun deleteAll()

}