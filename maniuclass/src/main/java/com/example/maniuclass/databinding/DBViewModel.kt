package com.example.maniuclass.databinding

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.maniuclass.BR

class DBViewModel: ViewModel() {

    private var user = MutableLiveData<User>(User())
    //基础数据类型可以使用封装类 但是User是自定义数据类型 若未初始化 则编译不通过
//    val user:LiveData<User> get() = _user

    fun getUser(): MutableLiveData<User> {
        return this.user
    }

    fun setUser(user: User){
//        this.user.postValue(user)
        this.user.postValue(user)
    }

    fun loginRequest(){
//        User(this.user.value?.getUsername().toString(),this.user.value?.getPassword().toString())
        val user = User("name ${(Math.random()*100).toInt()}","pwd")
        setUser(user)
//        Log.d(TAG,"User(${user.value?.getUsername()},${user.value?.getPassword()})")
    }

    companion object{
        const val TAG = "DBViewModel"
    }
}