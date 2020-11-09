package com.example.maniuclass.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.maniuclass.R
import kotlinx.android.synthetic.main.activity_ld.*

class LiveDataActivity : AppCompatActivity() {

    private val liveData = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ld)
        bt.setOnClickListener {
            liveData.postValue("123456")
        }
        liveData.postValue("123456")

        liveData.observe(this, Observer {
            Log.d(TAG,"value:${liveData.value}")
        })

        liveData.observe(this, Observer {
            Log.d(TAG,"value:${liveData.value}")
        })
    }

    companion object{
        const val TAG = "LiveDataActivity"
    }
}
