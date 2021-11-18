package com.application.moneymanager

import com.application.moneymanager.data.ExpensesTable
import com.application.moneymanager.data.IncomeTable

interface clickOnListener {

    fun onedit(incomeTable: IncomeTable)
    fun ondelete(incomeTable: IncomeTable)
}

interface clickondelete {
    fun onedit(expensesTable: ExpensesTable)
    fun ondelete(expensesTable: ExpensesTable)
}