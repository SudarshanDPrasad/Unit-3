package com.example.evaluation1.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.evaluation1.api.Network
import com.example.evaluation1.response.ResponseModel
import com.example.evaluation1.response.ResponseModelItem

class PagingSource : PagingSource<Int, ResponseModelItem>() {

    private val apiservice = Network.getApiService()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseModelItem> {

        val pageNumber = params.key ?: 1
        val responseModel: ResponseModel = apiservice.getResponse(pageNumber)
        val result: ArrayList<ResponseModelItem> = responseModel

        return try {
            LoadResult.Page(
                data = result,
                prevKey = null,
                nextKey = if (result.isEmpty()) null else pageNumber + 1
            )
        }catch (execption:Exception){
            LoadResult.Error(execption)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ResponseModelItem>): Int? {
        TODO("Not yet implemented")
    }


}