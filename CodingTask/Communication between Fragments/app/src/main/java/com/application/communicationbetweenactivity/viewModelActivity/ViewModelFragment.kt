package com.application.communicationbetweenactivity.viewModelActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelFragment : ViewModel() {

    private val mutableLiveDataA: MutableLiveData<Int> = MutableLiveData<Int>()
    private val mutableLiveDataB: MutableLiveData<Int> = MutableLiveData<Int>()

    fun setDataA(item: Int) {

        mutableLiveDataA.postValue(item)
    }

    fun setDataB(item: Int) {

        mutableLiveDataB.postValue(item)
    }

    fun getSelectedItemB(): LiveData<Int> {

        return mutableLiveDataB
    }

    fun getSelectedItemA(): LiveData<Int> {

        return mutableLiveDataA
    }
}