package com.application.scenariocinema.pagination

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData

class PagingRepo {

    fun getPageList() =
        Pager(
            config = PagingConfig(
                pageSize = 10
            ),
            pagingSourceFactory = { PagingSource() }
        ).liveData
}