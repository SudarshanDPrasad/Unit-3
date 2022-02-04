package com.example.rxjavarecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagination_recyclerview.response.Result
import com.example.rxjavarecyclerview.adaptor.MovieAdaptor
import com.example.rxjavarecyclerview.data.MainUIModel
import com.example.rxjavarecyclerview.data.PagingViewModel
import com.example.rxjavarecyclerview.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.rxjavarecyclerview.data.PagingSource as PagingSource1

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var pagingViewModel: PagingViewModel
    private lateinit var movieAdaptor: MovieAdaptor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        pagingViewModel = ViewModelProvider(this).get(PagingViewModel::class.java)
        setAdaptor()


        pagingViewModel.callApi().observe(this, {
            it?.let {
                CoroutineScope(Dispatchers.IO).launch {
                    movieAdaptor.submitData(it)
                }
            }
        })
    }

    private fun setAdaptor() {



        movieAdaptor = MovieAdaptor()
        val linearLayoutManager = LinearLayoutManager(this)
        activityMainBinding.recyclerview.apply {
            Log.d("sudarshan", activityMainBinding.recyclerview.size.toString())
            adapter = movieAdaptor
            layoutManager = linearLayoutManager
        }
    }
}