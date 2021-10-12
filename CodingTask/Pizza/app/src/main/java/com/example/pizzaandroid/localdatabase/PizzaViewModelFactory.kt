package com.example.pizzaandroid.localdatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pizzaandroid.data.PizzaRepo
import com.example.pizzaandroid.data.PizzaViewModel

class PizzaViewModelFactory(val repo: PizzaRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PizzaViewModel(repo) as T
    }

}