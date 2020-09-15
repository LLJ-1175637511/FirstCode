package com.example.thefirstcode.activity_launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.thefirstcode.R
import kotlinx.android.synthetic.main.activity_launchmode.*

class ActivitySingleTask:AppCompatActivity() {

    companion object{
        const val TAG = "ActivitySingleTask"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launchmode)

        intent_bt.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        Log.d(TAG,this.toString())
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(SecondActivity.TAG,"onRestart")
    }
}