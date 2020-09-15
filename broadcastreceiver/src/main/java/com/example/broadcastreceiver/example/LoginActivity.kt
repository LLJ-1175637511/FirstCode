package com.example.broadcastreceiver.example

import android.content.Intent
import android.os.Bundle
import com.example.broadcastreceiver.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity:BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_bt.setOnClickListener {
            val intent = Intent(this,FirstActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}