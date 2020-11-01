package com.example.tencentclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list = mutableListOf<Map<String,String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addData()

        val adapter = SimpleAdapter(this,list,R.layout.listitem, arrayOf("name","age"), intArrayOf(R.id.tv1,R.id.tv2))
        listView.adapter = adapter
    }

    private fun addData() {
        for (i in 1..10){
            val data1 = mutableMapOf<String,String>()
            data1["name"] = "zhang$i"
            data1["age"] = "${23+i}"
            list.add(data1)
        }
    }
}
