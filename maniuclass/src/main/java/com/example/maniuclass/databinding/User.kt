package com.example.maniuclass.databinding

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.maniuclass.BR


class User(
    private var username: String = "",
    private var password: String = ""
) : BaseObservable() {
    @Bindable
    fun getUsername(): String {
        return username
    }

    @Bindable
    fun setUsername(username: String) {
        this.username = username
        notifyPropertyChanged(BR.username)
    }

    @Bindable
    fun getPassword(): String {
        return password
    }

    @Bindable
    fun setPassword(password: String) {
        this.password = password
        notifyPropertyChanged(BR.password)
    }
}

