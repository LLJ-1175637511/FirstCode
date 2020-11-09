package com.example.maniuclass.databinding

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class PWD(private var uName: String) : BaseObservable() {
    @Bindable
    fun getuName(): String {
        return uName
    }

    @Bindable
    fun setuName(uName: String) {
        this.uName = uName
    }

}