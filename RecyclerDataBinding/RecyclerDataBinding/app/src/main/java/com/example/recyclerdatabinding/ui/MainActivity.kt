package com.example.recyclerdatabinding.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerdatabinding.Adaptor.MoviesAdaptor
import com.example.recyclerdatabinding.R
import com.example.recyclerdatabinding.databinding.ActivityMainBinding
import com.example.recyclerdatabinding.model.ViewModel
import com.example.recyclerdatabinding.response.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModel
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var popularMoviesAdapter: MoviesAdaptor
    var resultList = mutableListOf<Result>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)

        activityMainBinding.apply {
            popularMoviesAdapter = MoviesAdaptor(resultList)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = popularMoviesAdapter
        }


        viewModel.getDataFromApi().observe(this, Observer {
            resultList.clear()
            resultList.addAll(it)
            popularMoviesAdapter.notifyDataSetChanged()
        })

        viewModel.getDataFromApi()

    }
}