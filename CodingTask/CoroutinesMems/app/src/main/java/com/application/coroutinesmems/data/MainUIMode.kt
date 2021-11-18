package com.application.coroutinesmems.data

import com.application.coroutinesmems.apiresponse.Data
import com.application.coroutinesmems.apiresponse.ResponseDTO

sealed class MainUIMode {

    data class OnSucces(val data: ResponseDTO): MainUIMode()

    data class OnFailure(val error: String) : MainUIMode()
}