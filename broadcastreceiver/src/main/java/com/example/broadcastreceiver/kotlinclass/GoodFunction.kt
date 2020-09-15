package com.example.broadcastreceiver.kotlinclass

fun main() {
    val num1 = 15
    val num2 = 60
    //当{高阶函数}作为函数最后一个返回值时 可以移动到括号外
//    val result = addNum1AndNum2(num1,num2,{num1, num2 -> num1 + num2 })
    val result = addNum1AndNum2(num1,num2) { n1, n2 -> n1 + n2 }
    println(result)
}
