package com.example.thefirstcode.addview

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import com.example.thefirstcode.R

class AddViewActivity:AppCompatActivity() {

    private val myBt = arrayOf("7","8","9","÷","4","5","6","x","1","2","3","-",".","0","=","+")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gridelayout)

        val gl = findViewById<GridLayout>(R.id.gl_layout)
        var bt:Button
        var rowSpec: GridLayout.Spec
        var columnSpec: GridLayout.Spec
        var params: GridLayout.LayoutParams
        for (index in myBt.indices){
            bt = Button(this)
            bt.run {
                text = myBt[index]
                textSize = 40f
                setPadding(5,35,5,35)
            }
            rowSpec = GridLayout.spec(index/4+2)
            columnSpec = GridLayout.spec(index%4)
            params = GridLayout.LayoutParams(rowSpec, columnSpec)
            gl.addView(bt,params)
        }
    }
}