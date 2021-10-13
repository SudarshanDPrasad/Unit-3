package com.example.pizzaandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaandroid.DataModel.CartData
import com.example.pizzaandroid.R
import com.example.pizzaandroid.adaptor.CartAdaptor
import com.example.pizzaandroid.data.PizzaRepo
import com.example.pizzaandroid.data.PizzaViewModel
import com.example.pizzaandroid.databinding.ActivityCartBinding
import com.example.pizzaandroid.databinding.ActivityMainBinding
import com.example.pizzaandroid.localdatabase.Dao
import com.example.pizzaandroid.localdatabase.PizzaRoomDataBase
import com.example.pizzaandroid.localdatabase.PizzaViewModelFactory
import com.example.pizzaandroid.onCLiclListener.OnClickListener
import com.example.pizzaandroid.onCLiclListener.OnDeleteListener

class CartActivity : AppCompatActivity(), OnDeleteListener {


    lateinit var pizzaRoomDataBase: PizzaRoomDataBase
    lateinit var activityCartBinding: ActivityCartBinding
    lateinit var dao: Dao
    val cartList = mutableListOf<CartData>()
    private lateinit var pizzaViewModel: PizzaViewModel
    lateinit var cartAdapter: CartAdaptor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityCartBinding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(activityCartBinding.root)

        pizzaRoomDataBase = PizzaRoomDataBase.getDataBaseObject(this)
        dao = pizzaRoomDataBase.getTaskDAO()
        val repo = PizzaRepo(dao)
        val viewModelFactory = PizzaViewModelFactory(repo)
        pizzaViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(PizzaViewModel::class.java)


        cartAdapter = CartAdaptor(cartList, this)

        activityCartBinding.datarecyclerview.adapter = cartAdapter
        activityCartBinding.datarecyclerview.layoutManager = LinearLayoutManager(this)

        pizzaViewModel.getData().observe(this, Observer {
            cartList.clear()
            cartList.addAll(it)
            cartAdapter.notifyDataSetChanged()
            var totalamount = 0
            it.forEach {
                totalamount += it.PizzaPrice.toInt()
            }
            activityCartBinding.carttotalamount.text = totalamount.toString()
        })
    }

    override fun onDelete(cartData: CartData) {
        pizzaViewModel.deletetaskviewmodel(cartData)
    }

    override fun onAddExtra(cartData: CartData){
        pizzaViewModel.addtaskviewmodel(cartData)
    }
}