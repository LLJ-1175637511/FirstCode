package com.example.jetpack.lifecycles

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver(private val lifeCycle:Lifecycle):LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart(){
       Log.d(TAG,"activityStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop(){
        Log.d(TAG,"activityStop")
        val state = lifeCycle.currentState.name
        Log.d(TAG,state.toString())
    }

    fun getCurrentState(){
        val state = lifeCycle.currentState
        Log.d(TAG,state.toString())
    }

    companion object{
        const val TAG = "MyObserver"
    }
}