package com.application.moneymanager.dataexpenses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider



class ExpensesViewModelFactory(val repo: ExpensesRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ExpensesViewModel(repo) as T
    }

}