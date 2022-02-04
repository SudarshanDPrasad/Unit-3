package com.application.moneymanager.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IncomeRepo(val incomeDao: IncomeDao) {

    fun addIncome(incomeTable: IncomeTable) {
        CoroutineScope(Dispatchers.IO).launch {
            incomeDao.addIncome(incomeTable)
        }
    }

    fun getallTask(): LiveData<List<IncomeTable>> {
        return incomeDao.getAllTask()
    }
}