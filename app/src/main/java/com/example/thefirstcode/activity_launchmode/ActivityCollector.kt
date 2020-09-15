package com.example.thefirstcode.activity_launchmode

import android.app.Activity

object ActivityCollector {
    private val  activities = ArrayList<Activity>()

    fun addActivity(activity: Activity){
        activities.add(activity)
    }

    fun removeActivity(activity: Activity){
        activities.remove(activity)
    }

    fun finishedAll(){
        for (i in activities){
            if (!i.isFinishing){
                i.finish()
            }
        }
        activities.clear()
        android.os.Process.killProcess(android.os.Process.myPid())
    }
}