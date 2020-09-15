package com.example.broadcastreceiver.kotlinclass

import java.lang.StringBuilder

fun main() {
    val list = listOf("one","two","three")
    val result = StringBuilder().build {
        append("start\n")
        for (i in list){
            append(i)
            append("\n")
        }
        append("end")
    }
    println(result)
}

fun StringBuilder.build(block:StringBuilder.()->Unit):StringBuilder{
    block()
    return this
}