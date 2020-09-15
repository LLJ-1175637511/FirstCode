package com.example.thefirstcode.activity_launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.thefirstcode.R
import kotlinx.android.synthetic.main.activity_launchmode.*

class ActivitySingleInstance:BaseActivity() {

    companion object{
        const val TAG = "ActivitySingleInstance"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"task is $taskId")
        setContentView(R.layout.activity_launchmode)

        intent_bt.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }

}