package com.application.newsbreezeapp.repository

import io.reactivex.rxjava3.core.Observable
import com.application.newsbreezeapp.ApiCall.ResponseModel
import com.application.newsbreezeapp.api.NetworkHelper

class MainRepository {
    fun getNewsDetails(): Observable<ResponseModel> {
        return NetworkHelper.getApiService().getDeatils()
    }
}