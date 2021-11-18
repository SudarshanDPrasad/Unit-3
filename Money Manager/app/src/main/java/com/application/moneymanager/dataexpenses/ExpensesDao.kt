package com.application.moneymanager.dataexpenses

import androidx.lifecycle.LiveData
import androidx.room.*
import com.application.moneymanager.data.ExpensesTable
import com.application.moneymanager.data.IncomeTable

@Dao
interface ExpensesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addExpenses(task: ExpensesTable)

    @Query("select * from expenses")
    fun getAllTaskExpenses(): LiveData<List<ExpensesTable>>

    @Query("select SUM(Amount) as Total from expenses")
    fun getAllExpenses(): LiveData<Int>


    @Update
    fun updateexpenses(task: ExpensesTable)

    @Delete
    fun deleteexpenses(task: ExpensesTable)
}