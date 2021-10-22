package com.example.rxjavarecyclerview.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pagination_recyclerview.response.Result

class PagingViewModel : ViewModel() {

    private val repo = PagingRepo()

    fun callApi() =
        repo.getPages()

}