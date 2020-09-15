package com.example.thefirstcode.mystyleview

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.thefirstcode.R
import com.example.thefirstcode.toast
import kotlinx.android.synthetic.main.titlebar.view.*

class TitleLayout(context: Context,attrs:AttributeSet):LinearLayout(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.titlebar,this)
        titleBar_back.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
        titleBar_title.text = "my title view"
        titleBar_other.setOnClickListener {
            context.toast("other")
        }
    }

}
