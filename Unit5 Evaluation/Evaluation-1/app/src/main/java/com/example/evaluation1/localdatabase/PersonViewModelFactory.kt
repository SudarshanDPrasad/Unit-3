package com.example.evaluation1.localdatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.evaluation1.data.PagingRepo
import com.example.evaluation1.data.PagingViewModel

class PersonViewModelFactory(val repo: PagingRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PagingViewModel(repo) as T
    }
}