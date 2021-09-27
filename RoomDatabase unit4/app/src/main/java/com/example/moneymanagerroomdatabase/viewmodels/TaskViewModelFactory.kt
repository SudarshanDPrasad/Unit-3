package com.example.roomdatabase.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanagerroomdatabase.viewmodels.TaskViewModel
import com.example.moneymanagerroomdatabase.repository.TaskRepo

class TaskViewModelFactory(val repo: TaskRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TaskViewModel(repo) as T
    }

}