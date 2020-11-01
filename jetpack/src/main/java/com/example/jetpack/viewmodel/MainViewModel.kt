package com.example.jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel(cou:Int):ViewModel() {

    val count:LiveData<Int> get() = _counter
    private val _counter = MutableLiveData<Int>()

    //    private val userLiveData = MutableLiveData<User>()
    //1.map:从源数据userLiveData中提取出需要的数据返回 减少调用层的逻辑处理
//    val user:LiveData<String> = Transformations.map(userLiveData){
//        "${it.firstName} ${it.lastName}"
//    }

    private val userIdLiveData = MutableLiveData<String>()
    //2.switchMap
    val user:LiveData<User> = Transformations.switchMap(userIdLiveData){
        Repository.getUser(it)
    }

    init {
        _counter.value = cou
        userIdLiveData.value = ""
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

    fun getUser(userId:String){
        userIdLiveData.value = userId
    }
}