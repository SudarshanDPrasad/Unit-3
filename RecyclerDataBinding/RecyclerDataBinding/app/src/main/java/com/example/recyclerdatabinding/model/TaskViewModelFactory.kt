package com.example.recyclerdatabinding.model

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerdatabinding.repo.movieRepo

class TaskViewModelFactory(val repo: movieRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModel(repo) as T
    }

}