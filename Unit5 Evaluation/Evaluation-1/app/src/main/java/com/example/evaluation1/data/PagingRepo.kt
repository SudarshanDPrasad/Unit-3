package com.example.evaluation1.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData

class PagingRepo {

    fun getPageslIst() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
            ),
            pagingSourceFactory = { PagingSource() }
        ).liveData
}