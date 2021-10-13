package com.example.pagination_recyclerview.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingConfig.Companion.MAX_SIZE_UNBOUNDED
import androidx.paging.liveData

class ResultRepo {


    fun getPageList() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 60
            ),
            pagingSourceFactory = { ResultPagingSource() }
        ).liveData
}