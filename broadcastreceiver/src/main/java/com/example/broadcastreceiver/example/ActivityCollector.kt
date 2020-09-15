package com.example.broadcastreceiver.example

import android.app.Activity

object ActivityCollector {
    private var activityArray = arrayListOf<Activity>()
    fun addActivity(act:Activity){
        activityArray.add(act)
    }

    fun removeActivity(act: Activity){
        activityArray.remove(act)
    }

    fun clearAllActivity(){
        for (act in activityArray){
            if (!act.isFinishing) act.finish()
        }
        activityArray.clear()
    }
}