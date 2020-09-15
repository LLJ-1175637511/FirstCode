package com.example.fragmenttest.fragmentDisplay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmenttest.R
import com.example.fragmenttest.fragmentDisplay.FragmentTestActivity
import kotlinx.android.synthetic.main.fragment_two.*

class TwoFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btTwo.setOnClickListener {
            //fragment调用activity的方法
            if (activity!=null){
                val mainActivity = activity as FragmentTestActivity
                mainActivity.callActivity()
            }
        }
    }

    fun addMyTwoInfo(){
        println("suc")
    }
}