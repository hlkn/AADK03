package com.example.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val TAG = "MainViewModel"
    init {
        Log.i(TAG, "MainViewModel created!")
    }

    fun loadData() {
        // Do some work here
        Log.i(TAG, "lodData() executing...")
    }

}