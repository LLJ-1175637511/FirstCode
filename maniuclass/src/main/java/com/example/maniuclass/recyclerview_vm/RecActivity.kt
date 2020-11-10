package com.example.maniuclass.recyclerview_vm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maniuclass.R
import kotlinx.android.synthetic.main.rec_activity.*

class RecActivity:AppCompatActivity() {

    private val recyclerView by lazy { RecAdapter() }
    private lateinit var itemViewModel: RecViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rec_activity)

        itemViewModel = ViewModelProvider(this)[RecViewModel::class.java]

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = recyclerView

        bt_rec.setOnClickListener {
//            itemViewModel.loadData()
            itemViewModel.loadOneData()
            val list = itemViewModel.getUser()
            recyclerView.loadOneData(list[list.lastIndex])
        }

    }
}