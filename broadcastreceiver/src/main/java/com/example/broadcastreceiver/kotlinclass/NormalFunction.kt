package com.example.broadcastreceiver.kotlinclass

fun main() {
    val num1 = 11
    val num2 = 15
    //::函数 表示引用该函数
    val result = addNum1AndNum2(num1,num2,::plus)
    println(result)
}

inline fun addNum1AndNum2(num1:Int,num2:Int,operate:(num1:Int,num2:Int)->Int):Int{
    val result = operate(num1,num2)
    return result
}

fun plus(num1: Int,num2: Int): Int {
    return num1 + num2
}