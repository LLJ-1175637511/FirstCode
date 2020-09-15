package com.example.thefirstcode.mychat

fun main() {
    val week = UseEnumClass.星期一
    week.msg(week)

    val direction = Direction.NORTH
    direction.msg(direction)
}

enum class UseEnumClass {
    星期一,星期二,星期三,星期四,星期五,星期六,星期日;
    fun msg(uec:UseEnumClass){
        println(uec)
    }
}

enum class Direction constructor(val flag:Int){
    NORTH(1),SOUTH(2),WEST(3),EAST(4);

    fun msg(dc:Direction){
        //直接返回的依旧是枚举的对象NORTH
        println("默认：$dc")
        //使用实例对象（dc）.name 获取枚举对象的值North
        println("值：${dc.name}")
        //使用实例对象（dc）.ordinal 获取枚举对象的索引值0
        println("索引值：${dc.ordinal}")
        //使用实例对象（dc）.构造参数名（flag） 获取枚举对象对应的参数值1
        println("参数值：${dc.flag}")
        //使用类（枚举类）名.valueOf("NORTH") 获取和枚举类 对应对象的数值
        println("枚举对象对应的数值：${valueOf("NORTH")}")
    }

    /**
     * 重载枚举类的toString方法
     * 可以返回利用构造函数传来的参数
     */
//    override fun toString(): String {
//        return flag.toString()
//    }
}