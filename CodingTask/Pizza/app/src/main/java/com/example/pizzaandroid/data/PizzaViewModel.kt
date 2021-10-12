package com.example.pizzaandroid.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzaandroid.DataModel.CartData
import com.example.pizzaandroid.response.Crust
import com.example.pizzaandroid.response.Response_Model
import com.example.pizzaandroid.response.Size
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PizzaViewModel(val repo: PizzaRepo) : ViewModel() {

    private val mutableLiveData = MutableLiveData<List<Crust>>()
    val liveData: LiveData<List<Crust>> = mutableLiveData
    val mutableLiveDataCrust = MutableLiveData<List<Size>>()
    val liveDataCrust: LiveData<List<Size>> = mutableLiveDataCrust


    fun callApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repo.getAllData()
            mutableLiveData.postValue(response)
        }
    }

    fun callApiCrust() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repo.getAllDataCrust()
            mutableLiveDataCrust.postValue(response)
        }
    }

    fun addToDb(cartData: CartData){
        repo.insertData(cartData)
    }

    fun getData() :LiveData<List<CartData>>{
        return repo.getDataFormDB()
    }
}