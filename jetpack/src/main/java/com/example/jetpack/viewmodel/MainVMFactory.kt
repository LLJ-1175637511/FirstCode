package com.example.jetpack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainVMFactory(private var count:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LiveDateViewModel(count) as T
    }
}