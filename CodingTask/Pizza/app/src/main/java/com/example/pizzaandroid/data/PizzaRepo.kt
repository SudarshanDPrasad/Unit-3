package com.example.pizzaandroid.data

import com.example.pizzaandroid.response.Crust
import com.example.pizzaandroid.response.Response_Model
import com.example.pizzaandroid.response.ServiceGenerator
import com.example.pizzaandroid.response.Size

class PizzaRepo {
    suspend fun getAllData() : List<Crust>{
        return ServiceGenerator.getApiService().getcartfromapi().crusts
    }

    suspend fun getAllDatacrust() : List<Size> {
        return ServiceGenerator.getApiService().getcartfromapicrust().sizes
    }

}