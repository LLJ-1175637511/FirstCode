package com.example.tencentclass

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity

class MyViewActivity:AppCompatActivity() {
    private val view2 by lazy { MyView2(this) }
    private var time = 0L
    private var flag = false
    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            when(msg.what){
                0x10->{
                    view2.freshUi()
                }
            }
            super.handleMessage(msg)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view2)
        flag = true
        Thread(Runnable {
            while (flag){
                if ( System.currentTimeMillis() - time>50){
                    val msg = handler.obtainMessage()
                    msg.what = 0x10
                    handler.sendMessage(msg)
                    time = System.currentTimeMillis()
                }
            }
        }).start()
    }

    override fun onDestroy() {
        flag = false
        super.onDestroy()
    }
}