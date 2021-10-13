package com.example.pagination_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagination_recyclerview.adaptor.MovieAdaptor
import com.example.pagination_recyclerview.data.ResultViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var resultViewModel: ResultViewModel
    private lateinit var movieAdaptor: MovieAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultViewModel = ViewModelProvider(this).get(ResultViewModel::class.java)
        setAdaptor()

        resultViewModel.searchMovie().observe(this, {
            it?.let {
                CoroutineScope(Main).launch {
                    movieAdaptor.submitData(it)
                }
            }
        })
    }

    private fun setAdaptor() {
        movieAdaptor = MovieAdaptor()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerview.apply {
            adapter = movieAdaptor
            layoutManager = linearLayoutManager
        }
    }
}