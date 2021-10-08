package com.example.databindingmvvm.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databindingmvvm.response.Network
import com.example.databindingmvvm.R
import com.example.databindingmvvm.databinding.ActivityMainBinding
import com.example.databindingmvvm.repo.MovieRepo
import com.example.databindingmvvm.response.Result
import com.example.databindingmvvm.viewmodel.MovieViewModel
import com.example.databindingmvvm.viewmodel.MovieViewModelFactory
import com.example.recyclerdatabinding.Adaptor.MoviesAdaptor
import com.example.recyclerdatabinding.response.ApiCLinet

class MainActivity : AppCompatActivity() {

    lateinit var moviesAdaptor: MoviesAdaptor
    lateinit var movieViewModel: MovieViewModel
    lateinit var apiCLinet: ApiCLinet
    var movielist = mutableListOf<Result>()
    lateinit var activityMainBinding: ActivityMainBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        apiCLinet = Network.getInstance().create(ApiCLinet::class.java)

        val repo = MovieRepo(apiCLinet)

        val movieviewmodelFactory = MovieViewModelFactory(repo)

        movieViewModel = ViewModelProviders.of(this, movieviewmodelFactory).get(
            MovieViewModel::class.java)


        activityMainBinding.apply {
            moviesAdaptor = MoviesAdaptor(movielist)
            recyclerviewrc.adapter = moviesAdaptor
            recyclerviewrc.layoutManager = LinearLayoutManager(this@MainActivity)

        }

        activityMainBinding.apply {
            movieViewModel.getmovieapi()
        }

        movieViewModel.getmovieapi().observe(this@MainActivity, Observer {
            movielist.clear()
            movielist.addAll(it)
            moviesAdaptor.notifyDataSetChanged()

        })
    }
}