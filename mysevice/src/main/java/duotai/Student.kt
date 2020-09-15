package duotai

class Student(val grade:Int,name:String,age:Int):Person(name,age),Study {

    override fun study() {
        println("Stu:study")
    }

    fun doHomework(){
        work()
    }
}