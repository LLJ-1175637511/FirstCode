package com.example.fragmenttest.use_operator

fun main() {
    val money1 = Money(5)
    val money2 = Money(10)
    val money3 = money1 + money2
    println(money3.value)
}