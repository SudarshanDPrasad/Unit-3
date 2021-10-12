package com.masai.pagingnetworkand03.ui

import android.net.Network
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.masai.pagingnetworkand03.api.NetworkHelper
import com.masai.pagingnetworkand03.model.CharacterDTO
import com.masai.pagingnetworkand03.model.ResponseDTO
import java.lang.Exception

class CharacterPagingSource : PagingSource<Int, CharacterDTO>() {


    private val apiService = NetworkHelper.getApiService()
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDTO> {

        val pageNumber = params.key ?: 1
        val responseDTO: ResponseDTO = apiService.getCharactersByPage(pageNumber)
        val characterDTO: List<CharacterDTO> = responseDTO.results

        return try {
            LoadResult.Page(
                data = characterDTO,
                prevKey = null,
                nextKey = if (characterDTO.isEmpty()) null else pageNumber + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDTO>): Int? {
        return state.anchorPosition
    }
}