package com.example.mysevice

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class MyIntentService:JobIntentService() {

    override fun onHandleWork(intent: Intent) {
        val ss = 5
        val sa = 6
        println((ss + sa))
        Log.d(TAG,"this is ${Thread.currentThread().name}")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG,"onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d(TAG,"onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    fun workStart(context: Context,work:Intent){
        enqueueWork(context,MyIntentService::class.java, JOB_ID,work)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    companion object{
        const val TAG = "MyIntentService"
        val JOB_ID = 1000
    }
}