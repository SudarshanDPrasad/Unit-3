package com.application.newsapi.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.application.newsapi.response.Article
import com.application.newsapi.response.ResponseDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(val newsRepo: NewsRepo) : ViewModel() {

    fun getDataFromApi(): LiveData<Resource<ResponseDTO>> {
        return liveData(Dispatchers.IO) {
            val data = newsRepo.getNews()
            emit(data)
        }
    }

    fun addData(newsTable: List<Article>) {
        newsRepo.storeData(newsTable)
    }

    fun tableData() : LiveData<List<Article>>{
        return newsRepo.getData()
    }
}