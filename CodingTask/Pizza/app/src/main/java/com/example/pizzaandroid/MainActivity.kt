package com.example.pizzaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaandroid.adaptor.PizzaAdaptor
import com.example.pizzaandroid.data.MainUIModel
import com.example.pizzaandroid.data.PizzaViewModel
import com.example.pizzaandroid.databinding.ActivityMainBinding
import com.example.pizzaandroid.response.Crust
import com.example.pizzaandroid.response.Response_Model
import com.example.pizzaandroid.response.Size

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var pizzaViewModel: PizzaViewModel
    private var list = mutableListOf<Crust>()
    private var list1= mutableListOf<Size>()
    lateinit var pizzaAdaptor: PizzaAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.apply {
            pizzaAdaptor = PizzaAdaptor(list,list1)
            val linearLayoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = pizzaAdaptor
            recyclerView.layoutManager = linearLayoutManager
        }

        pizzaViewModel = ViewModelProvider(this).get(PizzaViewModel::class.java)
        pizzaViewModel.callApi()
        pizzaViewModel.liveData.observe(this, {

            list.clear()
            list.addAll(it)
            pizzaAdaptor.notifyDataSetChanged()
        })
        pizzaViewModel.callApicrust()
        pizzaViewModel.liveDatacrust.observe(this,{
            list1.clear()
            list1.addAll(it)
            pizzaAdaptor.notifyDataSetChanged()
        })
    }
}
