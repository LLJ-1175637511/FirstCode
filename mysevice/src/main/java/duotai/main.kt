package duotai

fun main() {
    val student = Student(22,"小红",16)
    student.doHomework()
    doWork(student)
}


/**
 * 多态：同种行为由不同对象产生不同的效果
 * 同种行为（doWork）
 * 不同对象 Student(22,"小红",16) Student(20,"小绿",16)
 * 不同效果...
 */
fun doWork(student: Student) {
    student.study()
}
