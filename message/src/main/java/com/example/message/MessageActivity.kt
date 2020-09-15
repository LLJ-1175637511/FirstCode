package com.example.message

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        NotificationObj.let {
            it.cancel(it.MESSAGE_ACTIVITY_ID)
        }
    }
}