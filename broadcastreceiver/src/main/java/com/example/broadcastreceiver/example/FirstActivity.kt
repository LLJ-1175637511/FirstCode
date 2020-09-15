package com.example.broadcastreceiver.example

import android.content.Intent
import android.os.Bundle
import com.example.broadcastreceiver.R
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity:BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        off_bt.setOnClickListener {
            val intent = Intent("com.example.broadcast.Force_OFFLINE")
            sendBroadcast(intent)
        }
    }
}