package com.example.recyclerdatabinding.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerdatabinding.repo.movieRepo
import com.example.recyclerdatabinding.response.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class ViewModel @Inject constructor(val repo: movieRepo) : ViewModel() {

    fun getDataFromApi() : LiveData<List<Result>> {
        return  repo.getMovieList()
    }
}