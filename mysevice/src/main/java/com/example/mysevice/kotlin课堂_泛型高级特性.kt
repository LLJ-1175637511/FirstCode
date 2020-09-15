package com.example.mysevice

class Test{
    fun foo(){
        bar<String>()
    }
    inline fun <T> bar(){
        println("sss")
    }
}

fun main() {
    Test().foo()
    val result1 = getGenericType<String>()
    val result2 = getGenericType<Int>()
    println("result1->${result1}  result2->${result2}")
}

/**
 * inline:内联函数 调用时将代码块 替换到调用处执行 不必创建新的实例
 * reified:实（例）化 可以借此知道泛型的类型 使用 a is T或T::class.java等语法
 */
inline fun <reified T> getGenericType() = T::class.java