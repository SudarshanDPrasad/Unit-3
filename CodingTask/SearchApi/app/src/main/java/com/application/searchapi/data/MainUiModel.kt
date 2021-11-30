package com.application.searchapi.data

import android.location.Address
import com.application.searchapi.response.ResponseDTO

sealed class MainUiModel() {
    data class OnSuccess(val responseDTO: ResponseDTO) : MainUiModel()
    data class OnFailure(val error: String) : MainUiModel()
}