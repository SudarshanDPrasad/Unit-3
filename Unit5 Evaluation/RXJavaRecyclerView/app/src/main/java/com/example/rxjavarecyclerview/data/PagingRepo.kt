package com.example.rxjavarecyclerview.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData

class PagingRepo {

    fun getPages() =
        Pager(
            config = PagingConfig(
                pageSize = 100,
            ),
            pagingSourceFactory = { PagingSource()}
        ).liveData


}
