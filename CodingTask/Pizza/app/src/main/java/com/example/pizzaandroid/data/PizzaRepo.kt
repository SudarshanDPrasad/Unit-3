package com.example.pizzaandroid.data

import androidx.lifecycle.LiveData
import com.example.pizzaandroid.DataModel.CartData
import com.example.pizzaandroid.localdatabase.Dao
import com.example.pizzaandroid.response.Crust
import com.example.pizzaandroid.response.Response_Model
import com.example.pizzaandroid.response.ServiceGenerator
import com.example.pizzaandroid.response.Size
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PizzaRepo(val dao: Dao) {

    suspend fun getAllData(): List<Crust> {
        return ServiceGenerator.getApiService().getcartfromapi().crusts
    }

    suspend fun getAllDataCrust(): List<Size> {
        return ServiceGenerator.getApiService().getcartcrust().sizes
    }

    fun insertData(cartData: CartData) {
        CoroutineScope(Dispatchers.IO).launch {
            val listresponse = dao.getSelected(cartData.PizzaName, cartData.PizzaSize)
            if (listresponse.size > 0) {
                var olddata = listresponse.get(0)
                olddata.PizzaPrice = olddata.PizzaPrice + cartData.PizzaPrice
                dao.UpdateData(olddata)
            } else {
                dao.insertData(cartData)
            }
        }
    }

    fun getDataFormDB(): LiveData<List<CartData>> {
        return dao.getData()
    }
}