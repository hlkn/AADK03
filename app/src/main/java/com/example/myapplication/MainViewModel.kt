package com.example.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val TAG = "MainViewModel"
    private val _info : MutableLiveData<Int> = MutableLiveData()
    init {
        Log.i(TAG, "MainViewModel created!")
        _info.value = 0
    }

    fun loadData() {
        // Do some work here
        _info.value = _info.value?.plus(1)
        //_info.value = _info.value!! + 1
        Log.i(TAG, "lodData() executing...value = ${_info.value}")
    }

}