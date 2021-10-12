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

    @Query("select * from Cart")
    fun getData() : LiveData<List<CartData>>

    @Delete()
    fun deleteTask(cartData: CartData)
}