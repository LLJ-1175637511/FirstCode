package com.example.thefirstcode.mychat

import java.lang.Exception

/**
 * 密封类的前身
 * 定会一个接口 由n个类去实现它
 * fun getMsgResult(result:Result){
 *      when(result){
 *          is Success -> result.msg
 *          is Failure -> result.error
 *          else -> throw IllegalArgumentException()
 *      }
 * }
 * else其实是走不到的 result类中只有两个实现类
 * 但当后期需要修改新增一个unKnow类也去实现Result时，就会走else（抛出异常）的分支 系统出现小bug
 * kotlin密封类 解决了这种问题 sealed class Result
 */
//interface Result
//class Success(val msg: String) : Result
//class Failure(val error: Exception) : Result

/**
 * 1、继承sealed密封类 需要Result加上() 等同（类的继承）
 * 将上述代码优化为
 * fun getMsgResult(result:Result){
 *      when(result){
 *          is Success -> result.msg
 *          is Failure -> result.error
 *      }
 * }
 */
sealed class Result
class Success(val msg: String) : Result()
class Failure(val error: Exception) : Result()