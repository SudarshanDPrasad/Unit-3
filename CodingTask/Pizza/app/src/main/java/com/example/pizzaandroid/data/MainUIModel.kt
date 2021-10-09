package com.example.pizzaandroid.data

import com.example.pizzaandroid.response.Crust
import com.example.pizzaandroid.response.Response_Model

sealed class MainUIModel {

    data class OnSuccess(val responseModel: Crust) : MainUIModel()

    data class onFailure(val error: String) : MainUIModel()
}