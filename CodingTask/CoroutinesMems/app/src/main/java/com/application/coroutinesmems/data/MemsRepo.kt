package com.application.coroutinesmems.data

import com.application.coroutinesmems.apiresponse.Data
import com.application.coroutinesmems.apiresponse.ResponseDTO
import com.application.coroutinesmems.interfaceapicall.ApiCall

class MemsRepo() {
    suspend fun getALLData(): ResponseDTO {
        return ServiceGenerator.getApiServices().getMemes()
    }
}