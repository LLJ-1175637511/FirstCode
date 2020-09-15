package com.example.thefirstcode.activity_life_cycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.thefirstcode.R
import kotlinx.android.synthetic.main.lifecycle_activity.*

class LifeCycleActivity:AppCompatActivity() {

    companion object{
        const val TAG = "LifeCycleActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lifecycle_activity)

        normal_bt.setOnClickListener {
            val intent = Intent(this,NormalActivity::class.java)
            startActivity(intent)
        }

        dialog_bt.setOnClickListener {
            val intent = Intent(this,DialogActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart")
    }
}