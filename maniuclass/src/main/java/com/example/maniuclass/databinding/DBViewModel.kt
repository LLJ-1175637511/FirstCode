package com.example.maniuclass.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class DBViewModel : ViewModel() {

    private var user = MutableLiveData(User())

//    //基础数据类型可以使用封装类 但是User是自定义数据类型 若未初始化 则编译不通过
////    val user:LiveData<User> get() = _user
//
    fun getUser(): MutableLiveData<User> {
        return this.user
    }

    fun setUser(user: User){
        this.user.postValue(user)
    }

    fun loginRequest(){
      val user = User("name ${(Math.random()*100).toInt()}","pwd")
//        val user = User("name ${(Math.random()*100).toInt()}","pwd")
        setUser(user)
    }

    companion object {
        const val TAG = "DBViewModel"
    }
}