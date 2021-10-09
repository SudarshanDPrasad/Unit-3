package com.example.pizzaandroid.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzaandroid.response.Crust
import com.example.pizzaandroid.response.Response_Model
import com.example.pizzaandroid.response.Size
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PizzaViewModel : ViewModel() {

    private val repo = PizzaRepo()
    private val mutableLiveData = MutableLiveData<List<Crust>>()
    val liveData: LiveData<List<Crust>> = mutableLiveData
    private val mutableLiveDatacrust = MutableLiveData<List<Size>>()
    val liveDatacrust: LiveData<List<Size>> = mutableLiveDatacrust

    fun callApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repo.getAllData()
            mutableLiveData.postValue(response)
        }
    }

    fun callApicrust() {
        CoroutineScope(Dispatchers.IO).launch {
            val response1 = repo.getAllDatacrust()
            mutableLiveDatacrust.postValue(response1)
        }
    }
}