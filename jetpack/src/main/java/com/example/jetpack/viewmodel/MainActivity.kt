package com.example.jetpack.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.jetpack.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var sp:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp = getPreferences(Context.MODE_PRIVATE)
        val cCount = sp.getInt("count",0)

        viewModel = ViewModelProvider(this,
            MainVMFactory(cCount)
        )[MainViewModel::class.java]

        bt.setOnClickListener {
            viewModel.plusOne()
        }

        clear.setOnClickListener {
            viewModel.clear()
        }

//        viewModel.count.observe(this, Observer {
//            tv.text = it.toString()
//        })

        //添加lifecycle-livedata-ktx依赖后 可以变为下面这种函数式编程写法
        viewModel.count.observe(this){
            tv.text = it.toString()
        }

        refreshUi()
    }

    private fun refreshUi() {
        tv.text = (viewModel.count.value?:0).toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count",viewModel.count.value?:0)
        }
    }
}
