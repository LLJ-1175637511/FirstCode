package com.example.jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(cou:Int):ViewModel() {

    val count:LiveData<Int> get() = _counter

    private val _counter = MutableLiveData<Int>()

    init {
        _counter.value = cou
    }

    /**
     * LiveData类型数据 只有三种操作方法
     * 1.getValue() 获取值
     * 2.setValue() 设置值（主线程，在子线程调用set方法会崩溃）
     * 3.postValue() 设置值（子线程）
     */
    fun plusOne(){
        val count = _counter.value ?:0
        _counter.value = count + 1
    }

    fun clear(){
        _counter.value = 0
    }
}