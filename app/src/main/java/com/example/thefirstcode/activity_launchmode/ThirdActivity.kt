package com.example.thefirstcode.activity_launchmode

import android.os.Bundle
import android.util.Log
import com.example.thefirstcode.R
import kotlinx.android.synthetic.main.thi_activity.*

class ThirdActivity:BaseActivity() {

    companion object{
        const val TAG = "ThirdActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"task is $taskId")
        setContentView(R.layout.thi_activity)
        return_bt.setOnClickListener {
            ActivityCollector.finishedAll()
        }
    }

}