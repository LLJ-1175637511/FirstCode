package com.example.mysevice

import android.content.Context
import android.content.Intent

/**
 * 使用内联实化特性 调用时直接使用
 * startActivity<MainActivity>()
 */
inline fun <reified T> startActivity(context: Context){
    val intent = Intent(context,T::class.java)
    context.startActivity(intent)
}

/**
 * 可以在构建Intent时添加一些参数
 */
inline fun <reified T> startActivity(context: Context, block:Intent.()->Unit){
    val intent = Intent(context,T::class.java)
    intent.block()
    context.startActivity(intent)
}

fun main() {
    //1、由于当前类无context上下文对象 编译会报错
//    startActivity<MainActivity>(context)
    //2、
//    startActivity<MainActivity>(context){
//        putExtra("param1","data1")
//        putExtra("param2","data2")
//    }

}

