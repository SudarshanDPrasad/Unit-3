package com.application.scenariocinema.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.application.scenariocinema.apiresources.ServiceGenerator
import com.application.scenariocinema.responseonemore.MovieResponse2
import com.application.scenariocinema.responseonemore.Result
import java.text.SimpleDateFormat
import java.util.*

class PagingSource : PagingSource<Int,Result>() {

    private val apiService = ServiceGenerator.getApiService()
    private var date = Calendar.getInstance().time
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd",Locale.getDefault())

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val pageNumber = params.key ?: 1
        val responseModel: MovieResponse2 = apiService.getDetails(dateFormat.format(date),pageNumber,)
        val result: List<Result> = responseModel.results

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
}