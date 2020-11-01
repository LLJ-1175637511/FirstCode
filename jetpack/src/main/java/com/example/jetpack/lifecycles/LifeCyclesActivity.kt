package com.example.jetpack.lifecycles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpack.R

class LifeCyclesActivity:AppCompatActivity() {
    private val lc by lazy { MyObserver(lifecycle) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lc)
        lifecycle.addObserver(lc)
    }

}