package com.example.rxjavarecyclerview.data

import com.example.pagination_recyclerview.response.Result

sealed class MainUIModel {

    data class OnSuccess(val result : List<Result>) : MainUIModel()

    data class OnFailure(val error: String) : MainUIModel()

}
