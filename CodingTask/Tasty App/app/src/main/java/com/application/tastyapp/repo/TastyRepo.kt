package com.application.tastyapp.repo

import android.widget.Toast
import com.application.tastyapp.response.api.TastyApi
import com.application.tastyapp.response.model.frontScreen.ItemX
import com.application.tastyapp.response.model.frontScreen.ResponseDto
import com.application.tastyapp.response.model.frontScreen.ResultModel
import com.application.tastyapp.response.module.Resource
import com.application.tastyapp.response.module.ResponseHandler
import com.application.tastyapp.response.module.TastyModule
import javax.inject.Inject

class TastyRepo @Inject constructor(val tastyApi: TastyApi) {
    val responseHandler: ResponseHandler = ResponseHandler()
    suspend fun getDetials(): Resource<List<ResultModel>> {
        return try {
            val data = TastyModule.ProvidesAPi().getDetails().resultModels
            responseHandler.handleSuccess(data)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}