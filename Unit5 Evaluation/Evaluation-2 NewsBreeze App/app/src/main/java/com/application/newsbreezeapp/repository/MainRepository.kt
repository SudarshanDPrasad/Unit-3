package com.application.newsbreezeapp.repository

import android.database.Observable
import com.application.newsbreezeapp.ApiCall.ResponseModel
import com.application.newsbreezeapp.api.NetworkHelper

class MainRepository {
    fun getNewsDetails(): Observable<ResponseModel> {
        return NetworkHelper.getApiService().getDeatils()
    }
}