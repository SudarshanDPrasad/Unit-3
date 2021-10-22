package com.example.rxjavarecyclerview.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagination_recyclerview.response.Result
import com.example.rxjavarecyclerview.api.NetworkHelper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observable.*
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList as ArrayList1

class PagingSource : PagingSource<Int, Result>() {

    private val apiService = NetworkHelper.getApiService()
    private var resultsList = arrayListOf<Result>()
    private lateinit var disposable: Disposable
    private val mutableLiveData = MutableLiveData<MainUIModel>()
    val liveData: LiveData<MainUIModel> = mutableLiveData

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {


        val pageNumber = params.key ?: 1

        val responseModel = apiService.getAllDetails(pageNumber).flatMap { (_, results) ->
            Observable.fromIterable(
                results
            )
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Result> {
                override fun onSubscribe(d: Disposable?) {
                    d?.let {
                        disposable = d
                    }
                }

                override fun onNext(result: Result?) {
                    result?.let {
                        resultsList.add(it)
                    }
                }

                override fun onError(e: Throwable?) {
                    Log.d("sudarshan", e?.message.toString())
                }

                override fun onComplete() {

                }
            })


//        disposable.dispose()

       return try {
            LoadResult.Page(
                data = resultsList,
                prevKey = null,
                nextKey = if (resultsList.isEmpty()) null else pageNumber + 1

            )

        } catch (execptoin: Exception) {
            LoadResult.Error(execptoin)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        TODO("Not yet implemented")
    }
}
