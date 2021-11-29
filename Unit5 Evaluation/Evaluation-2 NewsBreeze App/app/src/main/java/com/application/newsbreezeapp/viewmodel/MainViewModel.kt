package com.application.newsbreezeapp.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.newsbreezeapp.apicall.remote.ResponseDTOX
import com.application.newsbreezeapp.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class MainViewModel : ViewModel() {

        private val mainRepository = MainRepository()
    private val mutableLiveData = MutableLiveData<MainUiModel>()
    val liveData: LiveData<MainUiModel> = mutableLiveData
    private lateinit var disposable: Disposable
    var sudarshan: String = ""


    fun callApi() {
        mainRepository.getNewsDetails()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ResponseDTOX> {


                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onNext(responseModel: ResponseDTOX?) {
                    responseModel?.let {
                        mutableLiveData.value = MainUiModel.OnSuccess(it)
                    }
                }

                override fun onError(e: Throwable?) {
                    Log.d(sudarshan, e.toString())
                }

                override fun onComplete() {

                }

            })
    }
}