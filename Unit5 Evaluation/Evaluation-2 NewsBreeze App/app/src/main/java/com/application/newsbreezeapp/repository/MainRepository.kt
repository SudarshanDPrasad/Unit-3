package com.application.newsbreezeapp.repository

import io.reactivex.rxjava3.core.Observable
import com.application.newsbreezeapp.api.NetworkHelper
import com.application.newsbreezeapp.apicall.remote.ResponseDTOX

class MainRepository() {
    fun getNewsDetails(): Observable<ResponseDTOX> {
        return NetworkHelper.getApiService().getDeatils()
    }
}