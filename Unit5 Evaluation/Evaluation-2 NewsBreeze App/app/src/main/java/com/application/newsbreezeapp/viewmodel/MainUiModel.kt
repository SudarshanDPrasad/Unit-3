package com.application.newsbreezeapp.viewmodel

import com.application.newsbreezeapp.ApiCall.ResponseModel

sealed class MainUiModel {

    data class OnSuccess(val responseModel: ResponseModel) : MainUiModel()

    data class OnFailure(val error: String) : MainUiModel()
}