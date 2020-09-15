package com.example.thefirstcode.listview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.thefirstcode.R
import kotlinx.android.synthetic.main.recycleview_activity.*

class RecyclerActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycleview_activity)

        val data = mutableListOf<FruitBean>()
        repeat(8){
            data.add(FruitBean(R.drawable.ic_baseline_accessibility_24,setRandomLength("弱小的人类")))
            data.add(FruitBean(R.drawable.ic_baseline_bluetooth_24,setRandomLength("都是虫子")))
        }
        val adapter = RecycleAdapter(data)
        val layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
    }

    private fun setRandomLength(str:String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        for (i in 1..n){
            builder.append(str)
        }
        return builder.toString()
    }
}