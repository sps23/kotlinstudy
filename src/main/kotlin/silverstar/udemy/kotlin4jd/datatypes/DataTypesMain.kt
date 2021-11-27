package silverstar.udemy.kotlin4jd.datatypes

import silverstar.udemy.kotlin4jd.datatypes.java.JavaUtils

fun main() {

    val int1 = 12
    println(int1 is Int)

    var long1 = 24L
    println(long1 is Long)

    long1 = int1.toLong()

    val byte1: Byte = 111
    var short1: Short = 222

    short1 = byte1.toShort()


    var double1 = 432.556
    println(double1 is Double)

    val float1 = 321.554f
    println(float1 is Float)

    double1 = float1.toDouble()

    val char1 = 'n'
    val char2Int = 65
    println(char2Int.toChar())

    val bool1 = true
    println(bool1 is Boolean)

    val isVacation = true
    val onVacation = JavaUtils.isVacationTime(isVacation)
    println(onVacation)

    val anything: Any
}
