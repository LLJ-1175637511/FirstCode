package com.example.fragmenttest.use_operator

/**
 * 1、使用class XX{
 *    operator fun xx(XX){
 *    }
 * }
 * 在类中使用operator定义一个运算重载符的扩展方法
 * + -> plus()
 * - -> minus()
 * * -> times()
 * / -> div()
 * % -> rem()
 *
 * 2、可以在 class XX(任意定义参数)
 *    可以在 xx(XX):返回任意类型
 *    必须保持plus(参数为XX 即改类的对象类型)
 *
 * 3、可以应用在金融行业等 1美元+1人民币  在方法中定义换算
 */
class Money(val value:Int) {
    operator fun plus(money: Money):Money{
        val sum = value + money.value
        return Money(sum)
    }
}