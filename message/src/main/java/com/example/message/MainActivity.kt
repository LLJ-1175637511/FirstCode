package com.example.message

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt.setOnClickListener {
            NotificationObj.let {
                it.createNotification(
                    this,
                    "标题",
                    "内容",
                    R.drawable.author_icon,
                    it.MESSAGE_ACTIVITY_ID
                )
            }
        }
    }


}
