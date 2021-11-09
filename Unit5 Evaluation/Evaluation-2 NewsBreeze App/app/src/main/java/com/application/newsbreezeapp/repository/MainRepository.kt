package com.application.newsbreezeapp.repository

import io.reactivex.rxjava3.core.Observable
import com.application.newsbreezeapp.api.NetworkHelper
import com.application.newsbreezeapp.apicall.remote.ResponseDTOX
import com.application.newsbreezeapp.localdb.NewsDao
import com.application.newsbreezeapp.localdb.NewsTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainRepository() {
    fun getNewsDetails(): Observable<ResponseDTOX> {
        return NetworkHelper.getApiService().getDeatils()
    }
}