package com.application.newsapi.data

import androidx.lifecycle.LiveData
import com.application.newsapi.api.ServiceGenrator
import com.application.newsapi.response.Article
import com.application.newsapi.response.ResponseDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class NewsRepo @Inject constructor(val newsDao: NewsDao) {

    val responseHandler = ResponseHandler()
    suspend fun getNews(): Resource<ResponseDTO> {
        return try {
            val response = ServiceGenrator.getApiService().getApi()
            responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun storeData(newsTable: List<Article>) {
        CoroutineScope(Dispatchers.IO).launch {
            newsDao.deletefromdb()
            newsDao.getData(newsTable)
        }
    }

    fun getData() : LiveData<List<Article>>{
        return newsDao.getDb()
    }
}