package com.example.pizzaandroid.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaandroid.DataModel.CartData
import com.example.pizzaandroid.R
import com.example.pizzaandroid.adaptor.CrustAdaptor
import com.example.pizzaandroid.adaptor.PizzaAdaptor
import com.example.pizzaandroid.data.PizzaRepo
import com.example.pizzaandroid.data.PizzaViewModel
import com.example.pizzaandroid.databinding.*
import com.example.pizzaandroid.localdatabase.Dao
import com.example.pizzaandroid.localdatabase.PizzaRoomDataBase
import com.example.pizzaandroid.localdatabase.PizzaViewModelFactory
import com.example.pizzaandroid.onCLiclListener.OnClickListener
import com.example.pizzaandroid.response.Crust
import com.example.pizzaandroid.response.Size
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var pizzaViewModel: PizzaViewModel
    private var list = mutableListOf<Crust>()
    lateinit var pizzaAdaptor: PizzaAdaptor
    lateinit var crustAdaptor: CrustAdaptor
    lateinit var bottomSheetActivityBinding: BottomSheetActivityBinding
    lateinit var pizzaRoomDataBase: PizzaRoomDataBase
    lateinit var crustItemLayoutBinding: CrustItemLayoutBinding
    lateinit var dao: Dao
    var count: Int = 0
    var sum: Int = 0
    var newData = CartData("",0.0,"",1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)


        pizzaRoomDataBase = PizzaRoomDataBase.getDataBaseObject(this)
        dao = pizzaRoomDataBase.getTaskDAO()
        val repo = PizzaRepo(dao)
        val viewModelFactory = PizzaViewModelFactory(repo)
        pizzaViewModel = ViewModelProviders.of(this, viewModelFactory).get(PizzaViewModel::class.java)


        activityMainBinding.recyclerView.apply {
            pizzaAdaptor = PizzaAdaptor(list, this@MainActivity)
            val linearLayoutManager = LinearLayoutManager(this@MainActivity)
            adapter = pizzaAdaptor
            layoutManager = linearLayoutManager
        }

        pizzaViewModel = ViewModelProvider(this).get(PizzaViewModel::class.java)
        pizzaViewModel.callApi()
        pizzaViewModel.liveData.observe(this, {

            list.clear()
            list.addAll(it)
            pizzaAdaptor.notifyDataSetChanged()
        })


    }

    override fun onClick(crust: Crust) {

        bottomSheetActivityBinding = BottomSheetActivityBinding.inflate(layoutInflater)

        val bottomDialog = BottomSheetDialog(
            this@MainActivity, R.style.BottomSheetDialogTheme
        )
        val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
            R.layout.bottom_sheet_activity, bottomSheetActivityBinding.bottomsheet
//            findViewById<LinearLayout>(R.id.bottomsheet) ( Since we are using data binding we should not use find view by id )
        )
        var listonclick = arrayListOf<Size>()
        listonclick.addAll(crust.sizes)

//        setContentView(bottomSheetActivityBinding.root) ( bec of root error )

        bottomSheetActivityBinding.crustrecyclerview.apply {
            adapter = CrustAdaptor(listonclick, this@MainActivity)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }


        bottomSheetActivityBinding.showcart.setOnClickListener {
            val intent = Intent(this@MainActivity, CartActivity::class.java)
            startActivity(intent)
        }

        newData.PizzaName =crust.name
        bottomDialog.setContentView(bottomSheetView)
        bottomDialog.show()
    }

    override fun onAddClick(size: Size) {

        count++
        bottomSheetActivityBinding.quntaity.text = newData.PizzaQunatity.toString()

        sum += size.price.toInt()

        bottomSheetActivityBinding.totalSum.text = "total amount " + sum.toString()
        if (count > 0) {
            bottomSheetActivityBinding.buttonshow.visibility = View.VISIBLE
        } else {
            bottomSheetActivityBinding.buttonshow.visibility = View.INVISIBLE

        }
        Toast.makeText(this, "the item is added to cart ", Toast.LENGTH_SHORT).show()
        newData.PizzaSize = size.name
        newData.PizzaPrice = size.price
        pizzaViewModel.addToDb(newData)
    }

    override fun onRemoveCLick(size: Size) {

        count--

        sum -= size.price.toInt()

        bottomSheetActivityBinding.quntaity.text = count.toString()
        bottomSheetActivityBinding.totalSum.text = "total amount " + sum.toString()
        Toast.makeText(this, "the item is removed from cart ", Toast.LENGTH_SHORT).show()

    }

}
