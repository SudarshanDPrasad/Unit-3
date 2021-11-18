package com.application.moneymanager.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider



class IncomeViewModelFactory(val repo: IncomeRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return IncomeViewModel(repo) as T
    }

}