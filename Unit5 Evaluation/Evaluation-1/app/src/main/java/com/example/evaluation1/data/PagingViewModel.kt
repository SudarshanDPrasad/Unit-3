package com.example.evaluation1.data

import androidx.lifecycle.ViewModel

class PagingViewModel : ViewModel() {

    private val repo = PagingRepo()

    fun getPages() =
        repo.getPageslIst()
}