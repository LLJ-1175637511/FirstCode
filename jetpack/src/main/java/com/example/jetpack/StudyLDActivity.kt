package com.example.jetpack

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_studyld.*

class StudyLDActivity:AppCompatActivity() {

    private var liveData = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studyld)
        bt.setOnClickListener {

            liveData.postValue("123456")
        }

        liveData.observe(this, Observer {
            Log.d(TAG,"value:${it}")
        })
        liveData.observe(this, Observer {
            Log.d(TAG,"value:${it}")
        })
    }

    companion object{
        const val TAG = "StudyLDActivity"
    }
}