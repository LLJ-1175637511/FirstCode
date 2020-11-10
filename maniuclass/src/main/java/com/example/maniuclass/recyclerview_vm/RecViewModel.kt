package com.example.maniuclass.recyclerview_vm

import androidx.lifecycle.ViewModel

class RecViewModel : ViewModel() {
    private val user = mutableListOf<ItemBean>()

    fun getUser(): MutableList<ItemBean> {
        return this.user
    }

    fun setUser(user: MutableList<ItemBean>) {
        this.user.apply {
            clear()
            addAll(user)
        }
    }

    fun loadData() {
        val list = mutableListOf<ItemBean>()
        for (i in 0..5) {
            val item = ItemBean((Math.random() * 100).toInt().toString(), "pwd")
            list.add(item)
        }
        setUser(list)
    }


    fun loadOneData() {
        val item = ItemBean((Math.random() * 100).toInt().toString(), "pwd")
        this.user.add(item)
    }

}