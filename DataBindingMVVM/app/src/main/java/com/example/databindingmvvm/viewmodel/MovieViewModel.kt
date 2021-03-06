package com.example.databindingmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.databindingmvvm.repo.MovieRepo
import com.example.databindingmvvm.response.IndianToon
import com.example.databindingmvvm.response.Result

class MovieViewModel(val movie: MovieRepo) : ViewModel() {


    fun getmovieapi(): LiveData<List<IndianToon>> {
        val response = movie.getmoviedetails()
        return response
    }
}