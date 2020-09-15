package com.example.fragmenttest.fragmentDisplay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmenttest.R
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentTestActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_test)

        //动态添加fragment
        val supportFragment = supportFragmentManager
        val translation = supportFragment.beginTransaction()
        translation.addToBackStack(null)
        translation.replace(R.id.fragment, TwoFragment())
        translation.commit()

        btOne.setOnClickListener {
            //在activity中调用fragment中的方法
            val twoFragment = supportFragment.findFragmentById(R.id.fragment) as TwoFragment
            //使用kotlin-android-extensions插件中的api 定义在xml中的fragment可以直接使用id获取实例 调用其中的方法
//        val oneFragment = leftFragment as OneFragment
            twoFragment.addMyTwoInfo()
        }
    }

    fun callActivity(){
        println("act")
    }
}