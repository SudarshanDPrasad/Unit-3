package com.application.itunessong.data

import com.application.itunessong.responsemodel.ResponseDTO

sealed class MainUiModel {

    data class OnSuccess(val responseDTO: ResponseDTO) : MainUiModel()
    data class OnFailure(val error: String) : MainUiModel()
}