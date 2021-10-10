package com.example.pizzaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaandroid.adaptor.PizzaAdaptor
import com.example.pizzaandroid.data.MainUIModel
import com.example.pizzaandroid.data.PizzaViewModel
import com.example.pizzaandroid.databinding.ActivityMainBinding
import com.example.pizzaandroid.onCLiclListener.OnClickListener
import com.example.pizzaandroid.response.Crust
import com.example.pizzaandroid.response.Response_Model
import com.example.pizzaandroid.response.Size
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var pizzaViewModel: PizzaViewModel
    private var list = mutableListOf<Crust>()
    lateinit var pizzaAdaptor: PizzaAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

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

        val bottomDialog = BottomSheetDialog(
            this@MainActivity, R.style.BottomSheetDialogTheme
        )

        val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
            R.layout.bottom_sheet_activity,
            findViewById<LinearLayout>(R.id.bottmsheet)
        )

        Toast.makeText(this, "hey its working ", Toast.LENGTH_SHORT).show()
        bottomDialog.setContentView(bottomSheetView)
        bottomDialog.show()
    }
}
