package com.application.moneymanager.dataexpenses

import androidx.lifecycle.LiveData
import com.application.moneymanager.data.ExpensesTable
import com.application.moneymanager.data.IncomeTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExpensesRepo(val expensesDao: ExpensesDao) {

    fun addExpenses(expensesTable: ExpensesTable) {
        CoroutineScope(Dispatchers.IO).launch {
            expensesDao.addExpenses(expensesTable)
        }
    }

    fun getallExpenses(): LiveData<List<ExpensesTable>> {
        return expensesDao.getAllTaskExpenses()

    }
}