package com.application.contactreadapp

import androidx.paging.PagingSource
import androidx.paging.PagingState

class PagingSourceItem(
    private val contactList: ArrayList<ContactTable>
) : PagingSource<Int, ContactTable>() {


    override fun getRefreshKey(state: PagingState<Int, ContactTable>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ContactTable> {
        val pageNumber = params.key ?: 1
        return try {
            LoadResult.Page(
                data = contactList,
                prevKey = null,
                nextKey = if (contactList.isEmpty()) null else pageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}