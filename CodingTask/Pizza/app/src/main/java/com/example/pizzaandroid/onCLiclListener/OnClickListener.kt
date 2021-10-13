package com.example.pizzaandroid.onCLiclListener

import com.example.pizzaandroid.DataModel.CartData
import com.example.pizzaandroid.response.Crust
import com.example.pizzaandroid.response.Size

interface OnClickListener {

    fun onClick(crust: Crust)
    fun onAddClick(size: Size)
    fun onRemoveCLick(size: Size)
}

interface OnDeleteListener{
    fun onDelete(cartData: CartData)
    fun onAddExtra(cartData: CartData)
}
