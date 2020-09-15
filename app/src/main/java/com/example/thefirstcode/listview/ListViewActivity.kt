package com.example.thefirstcode.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.thefirstcode.R
import kotlinx.android.synthetic.main.listview_activity.*

class ListViewActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview_activity)

//        val data = listOf("app","ios","father","mother")
//        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,data)
//        listView.adapter = adapter

        val data = mutableListOf<FruitBean>()
        repeat(8){
            data.add(FruitBean(R.drawable.ic_baseline_accessibility_24,"人类"))
            data.add(FruitBean(R.drawable.ic_baseline_bluetooth_24,"蓝牙"))
        }
        val adapter = ListViewAdapter(this,R.layout.listview_item,data)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->

        }
    }
}