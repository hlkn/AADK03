package com.example.myapplication

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver : LifecycleObserver {
    val TAG = "Lifecycle_monitor"
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connect() {
        Log.i(TAG, "onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun disconnect() {
        Log.i(TAG, "onPause")
    }

}
