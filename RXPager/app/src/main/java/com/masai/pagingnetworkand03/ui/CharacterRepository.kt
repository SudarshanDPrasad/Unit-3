package com.masai.pagingnetworkand03.ui

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import kotlin.math.max

class CharacterRepository {

    fun getPagesList() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
//                maxSize = 70
            ),
            pagingSourceFactory = { CharacterPagingSource() }
        ).liveData
}