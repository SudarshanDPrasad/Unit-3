package com.example.pagination_recyclerview.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagination_recyclerview.api.NetworkHelper
import com.example.pagination_recyclerview.response.Response_Model
import com.example.pagination_recyclerview.response.Result

class ResultPagingSource : PagingSource<Int, com.example.pagination_recyclerview.response.Result>() {


    private val apiService = NetworkHelper.getApiService()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, com.example.pagination_recyclerview.response.Result> {

        val pageNumber = params.key ?: 1
        val responseModel: Response_Model = apiService.getAllDetails(pageNumber)
        val result: List<com.example.pagination_recyclerview.response.Result> = responseModel.results

        return try {
            LoadResult.Page(
                data = result,
                prevKey = null,
                nextKey = if (result.isEmpty()) null else pageNumber + 1
            )
        } catch (expection: Exception) {
            LoadResult.Error(expection)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }
}