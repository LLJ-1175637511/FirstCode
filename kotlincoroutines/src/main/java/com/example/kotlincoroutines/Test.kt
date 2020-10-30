package com.example.kotlincoroutines

import kotlinx.coroutines.*

fun main() {
    //1.创建协程
//    GlobalScope.launch{
//        print("start coroutines")
//    }
//    Thread.sleep(1000)

    //2.
//    GlobalScope.launch{
//        print("start coroutines")
//        delay(1500)
//        print("restart coroutines")
//    }
//    Thread.sleep(1000)

    //3.runBlocking阻塞当前线程至协程执行完毕 开发应用不建议使用
//    runBlocking{
//        print("start coroutines")
//        delay(1500)
//        print("restart coroutines")
//    }

    //4.创建多个协程
//    runBlocking {
//        launch {
//            println("first start coroutines")
//            delay(1500)
//            println("double start coroutines")
//        }
//
//        launch{
//            println("first coroutines")
//            delay(1500)
//            println("double coroutines")
//        }
//    }

    //5.挂起函数suspend关键字
//    runBlocking {
//        printPoi()
//    }

    //6.结果同4
//    runBlocking{
//        launch{
//            println("launch1")
//            delay(1000)
//            println("launch1 end")
//        }
//        printPoint()
//    }
//    runBlocking{
//
//    }

    //7.
    runBlocking{
        coroutineScope{
               for(i in 1..10){
                   printPoi()
               }
            println("poi end")
        }
        println("coroutineScope end")
    }
    println("runBlocking end")
}

/**
 * 挂起函数suspend关键字
 * 可以运行在协程作用域中 但它本身并不具有协程作用域 无法调用launch 创建新协程
 */
suspend fun printPoi() {
    println(".")
    delay(1000)
//    launch{
//
//    }
}

/**
 * coroutineScope
 * 1.可以继承外部协程作用域并创建一个子协程作用域 可以调用launch 创建新协程
 * 2.类似launch 在代码块未执行完之前 会一直阻塞 不过launch阻塞当前线程 而coroutineScope仅仅阻塞当前协程（实验7）
 */
suspend fun printPoint() = coroutineScope {
    launch {
        println("launch2")
        delay(1000)
        println("launch2 end")
    }
}