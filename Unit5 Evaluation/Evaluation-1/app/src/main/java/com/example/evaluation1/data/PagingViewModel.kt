package com.example.evaluation1.data

import androidx.lifecycle.ViewModel

class PagingViewModel(val repo: PagingRepo) : ViewModel() {


    fun getPages() =
        repo.getPageslIst()


}