package com.application.newsbreezeapp.viewmodel

import com.application.newsbreezeapp.apicall.remote.ResponseDTOX


sealed class MainUiModel {

    data class OnSuccess(val responseModel: ResponseDTOX) : MainUiModel()

    data class OnFailure(val error: String) : MainUiModel()
}