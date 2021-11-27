package academy.learnprogramming.challenge9

import silverstar.udemy.learningkotlin.javainterop.java.Employee

fun main() {

    val employee = Employee("Jane", "Smith", 2000)

    employee.lastName = "Jones"
    employee.salaryLast3Years = floatArrayOf(50000.25f, 54000.60f, 56800.42f)

    println(employee)
}
