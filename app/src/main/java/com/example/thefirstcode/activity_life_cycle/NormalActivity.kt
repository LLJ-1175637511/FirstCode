package com.example.thefirstcode.activity_life_cycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.thefirstcode.R

class NormalActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)
    }
}