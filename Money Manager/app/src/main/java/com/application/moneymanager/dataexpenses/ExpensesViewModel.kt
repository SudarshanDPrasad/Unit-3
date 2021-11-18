package com.application.moneymanager.dataexpenses

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.application.moneymanager.data.ExpensesTable
import com.application.moneymanager.data.IncomeTable

class ExpensesViewModel(val repo: ExpensesRepo) : ViewModel() {

    fun addExpenses(expensesTable: ExpensesTable) {
        repo.addExpenses(expensesTable)
    }

    fun getExpenses(): LiveData<List<ExpensesTable>> {
        return repo.getallExpenses()
    }
}