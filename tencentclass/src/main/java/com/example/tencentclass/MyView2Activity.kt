package com.example.tencentclass

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread

class MyView2Activity:AppCompatActivity() {
    private val view2 by lazy { MyView2(this) }
    private var time = 0L
    private var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view2)
        flag = true
        thread {
            while (flag){
                if (System.currentTimeMillis()-time>50){
                    view2.freshUi()
                    time = System.currentTimeMillis()
                }
            }
        }
    }

    override fun onDestroy() {
        flag = false
        super.onDestroy()
    }
}