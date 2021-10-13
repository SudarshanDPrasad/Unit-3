package com.example.pizzaandroid.DataModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Cart")
class CartData (@ColumnInfo(name = "PizzaSize") var PizzaSize:String,
                @ColumnInfo(name = "PizzaPrice") var PizzaPrice:Double,
                @ColumnInfo(name = "PizzaName") var PizzaName:String,
                @ColumnInfo(name = "PizzaQunatity") var PizzaQunatity:Int){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}