package com.example.maniuclass.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.maniuclass.BR
import com.example.maniuclass.R
import kotlinx.android.synthetic.main.activity_db.*

class DataBindingActivity : AppCompatActivity() {

    private lateinit var dBViewModel:DBViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        val viewModelProvider = ViewModelProvider(this,factory)
        dBViewModel = viewModelProvider.get(DBViewModel().javaClass)

        val activityDbBinding =
            DataBindingUtil.setContentView<ActivityDbBinding>(this, R.layout.activity_db)
        activityDbBinding.dbViewModel = dBViewModel

        bt_login.setOnClickListener {
            dBViewModel.loginRequest()
        }
 
        dBViewModel.getUser().observe(this, Observer {
            //判断服务器返回结果
            activityDbBinding.invalidateAll()
            Log.d(TAG,"change to->User(${it?.getUsername()},${it?.getPassword()})")
        })
    }

    companion object{
        const val TAG = "DataBindingActivity"
    }
}
