package com.example.kotlincoroutines

import kotlinx.coroutines.*

fun main(){
    //1.安卓中推荐的使用写法 创建一个job对象 获得一个CoroutineScope函数的实例 来创建协程 当程序执行中 或
    //执行结束 都可以调用cancel（）方法来终止协程 便于协程管理
//    val job = Job()
//    val scope = CoroutineScope(job)
//    scope.launch{
//        println("hhh")
//        delay(1000)
//    }
//    job.cancel()

    //2.在学习的测试过程中 还是使用runblocking更为方便
    // async函数是一种串行运行函数 可以调用.await()函数（阻塞协程式） 获取执行返回值
    //程序共耗时2541ms
//    runBlocking{
//        val start = System.currentTimeMillis()
//        val result1 = async{
//            delay(1000)
//            5 + 5
//        }.await()
//        val result2 = async{
//            delay(1500)
//            4+4
//        }.await()
//        println("result:$result1 $result2")
//        val end = System.currentTimeMillis()
//        println("cost ${end-start}ms")
//    }

    //3.当程序全部执行完毕 再调用.await()函数（阻塞协程式） 获取结果
    //程序变成了并行 耗时1500ms
    runBlocking{
        val start = System.currentTimeMillis()
        val result1 = async{
            delay(1000)
            5 + 5
        }
        val result2 = async{
            delay(1000)
            4+4
        }
        println("result:${result1.await()+result2.await()}")
        val end = System.currentTimeMillis()
        println("cost ${end-start}ms")
    }
}