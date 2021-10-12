package com.example.pizzaandroid.localdatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.pizzaandroid.DataModel.CartData
import com.example.pizzaandroid.response.Crust

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(cartData: CartData)


    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun UpdateData(cartData: CartData)

    @Query("select * from Cart")
    fun getData() : LiveData<List<CartData>>

    @Query("select * from Cart where PizzaName=:pizzaName and PizzaSize=:pizzaSize")
    fun getSelected(pizzaName : String, pizzaSize : String) : List<CartData>

    @Delete()
    fun deleteTask(cartData: CartData)
}