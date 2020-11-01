package com.example.tencentclass

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.View


class MyView2:View{

    private var x = 0
    private lateinit var bmpBackGround: Bitmap

    constructor(context: Context?) : super(context){
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init()
    }

    private fun init(){
        bmpBackGround = BitmapFactory.decodeResource(resources,R.drawable.mydrawing)
    }

    override fun onDraw(canvas: Canvas?) {
        Log.d(TAG, "canvas:${canvas==null}")
        super.onDraw(canvas)
        moveBackGround(canvas)
    }

    private fun moveBackGround(canvas: Canvas?){
        x-=10
        val x2 = bmpBackGround.width-(-x)
        if(x2<=0){
            //移出屏幕
            x=0
            canvas?.drawBitmap(bmpBackGround,x.toFloat(),10F,null)
        }else{
            canvas?.drawBitmap(bmpBackGround,x.toFloat(),10F,null)
            canvas?.drawBitmap(bmpBackGround,x2.toFloat(),10F,null)
        }
    }

    fun freshUi() {
        Log.d(TAG, "freshUi")
            //不能直接调用ondraw
        postInvalidate()//重绘view(在线程中) 重绘view(不在线程中直接用Invalidate())
    }

    companion object{
        const val TAG = "MyView2"
    }
}