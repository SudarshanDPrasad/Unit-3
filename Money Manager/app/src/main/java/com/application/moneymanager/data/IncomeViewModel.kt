package com.application.moneymanager.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class IncomeViewModel(val repo: IncomeRepo) : ViewModel() {

    fun addIncome(incomeTable: IncomeTable) {
        repo.addIncome(incomeTable)
    }

    fun getIncome(): LiveData<List<IncomeTable>> {
        return repo.getallTask()
    }
}