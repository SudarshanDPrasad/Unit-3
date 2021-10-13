package com.example.pagination_recyclerview.data

import androidx.lifecycle.ViewModel

class ResultViewModel : ViewModel() {

    private val repo = ResultRepo()

    fun searchMovie() =
        repo.getPageList()

}