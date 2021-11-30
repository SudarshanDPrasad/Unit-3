package com.application.searchapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.searchapi.adaptor.CityAdaptor
import com.application.searchapi.data.CityViewModel
import com.application.searchapi.data.MainUiModel
import com.application.searchapi.data.Status
import com.application.searchapi.databinding.ActivityMainBinding
import com.application.searchapi.response.Address
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity() {

    private lateinit var cityViewModel: CityViewModel
    private var list = emptyList<Address>()
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)


        cityViewModel = ViewModelProviders.of(this).get(CityViewModel::class.java)
        searchedittext()
    }

    private fun searchedittext() {
        activityMainBinding.etSearchCity.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                loadapi(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

    }

    private fun loadapi(query: String) {
//        cityViewModel.liveData.observe(this, {
//            it.let {
//                when (it) {
//                    is MainUiModel.OnSuccess -> {
//                            list = it.responseDTO.data.addressList as ArrayList<Address>
//                            val adaptor = CityAdaptor(list)
//                            val layoutManager = LinearLayoutManager(this)
//                            rcyclerviewMain.adapter = adaptor
//                            rcyclerviewMain.layoutManager = layoutManager
//                        }
//
//                    is MainUiModel.OnFailure ->{
//                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//        })
//        cityViewModel.getData(query)
        cityViewModel.getData(query).observe(this, {

            when (it.status) {
                Status.ERROR -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }

                Status.SUCCESS -> {
                    list = it.data?.data?.addressList!!
                    val adaptor = CityAdaptor(list)
                    val layoutManager = LinearLayoutManager(this)
                    activityMainBinding.rcyclerviewMain.adapter = adaptor
                    activityMainBinding.rcyclerviewMain.layoutManager = layoutManager
                }
            }
        })
    }
}