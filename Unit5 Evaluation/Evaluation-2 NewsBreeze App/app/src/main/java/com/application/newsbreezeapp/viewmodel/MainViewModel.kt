package com.application.newsbreezeapp.viewmodel

import androidx.lifecycle.ViewModel
import com.application.newsbreezeapp.ApiCall.ResponseModel
import com.application.newsbreezeapp.repository.MainRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {

    private val mainRepository = MainRepository()

    fun callApi() {
        mainRepository.getNewsDetails()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ResponseModel>{


                override fun onSubscribe(d: Disposable?) {

                }

                override fun onNext(t: ResponseModel?) {

                }

                override fun onError(e: Throwable?) {

                }

                override fun onComplete() {

                }

            })
    }
}