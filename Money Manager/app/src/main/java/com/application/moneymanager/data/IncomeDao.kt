package com.application.moneymanager.data

import androidx.lifecycle.LiveData
import androidx.room.*
import okhttp3.internal.concurrent.Task

@Dao
interface IncomeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addIncome(task: IncomeTable)

    @Query("select * from income")
    fun getAllTask(): LiveData<List<IncomeTable>>

    @Query("select SUM(Amount) as Total from income")
    fun getAllIncome(): LiveData<Int>

    @Update
    fun updateincome(task: IncomeTable)

    @Delete
    fun deleteIncome(task: IncomeTable)
}