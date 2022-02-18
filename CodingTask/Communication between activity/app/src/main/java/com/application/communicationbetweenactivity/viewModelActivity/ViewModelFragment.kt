package com.application.communicationbetweenactivity.viewModelActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelFragment : ViewModel() {

    private val mutableLiveData: MutableLiveData<Int> = MutableLiveData<Int>()

    fun setData(item: Int) {

        mutableLiveData.postValue(item)
    }

    fun getSelectedItem(): LiveData<Int> {

        return mutableLiveData
    }
}