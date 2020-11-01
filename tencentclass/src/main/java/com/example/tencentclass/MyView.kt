package com.example.tencentclass

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MyView: View {

    private lateinit var mPaint:Paint
    private lateinit var mBitmap: Bitmap

    constructor(context: Context?) : super(context){
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    private fun init(){
        mPaint = Paint().apply {
            color = Color.BLUE
            style = Paint.Style.STROKE
            strokeWidth = 5F
        }
        mBitmap = BitmapFactory.decodeResource(resources,R.drawable.myloc)
    }

    /**
     * canvas相当于画布
     */
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
//        canvas?.drawCircle(50F,50F,50F,mPaint)
//        canvas?.drawRect(50F,120F,150F,180F,mPaint)
        val bitmap = Bitmap.createScaledBitmap(mBitmap,100,100,true)
        canvas?.drawBitmap(bitmap,400F,400F,null)
        super.onDraw(canvas)
    }

    companion object{
        const val TAG = "MyView"
    }
}