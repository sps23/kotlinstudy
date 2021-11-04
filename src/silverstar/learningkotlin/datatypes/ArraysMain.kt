package silverstar.learningkotlin.datatypes

import silverstar.learningkotlin.datatypes.java.JavaUtils
import java.math.BigDecimal

fun main() {

    val names = arrayOf("John", "Tom", "Jane", "Ann")
    val longs1 = arrayOf(1L, 2L, 3L)
    val longs2 = arrayOf<Long>(34, 56, 72)
    val longs3 = arrayOf(1, 2, 3)

    println(longs1 is Array<Long>)
    println(longs2 is Array<Long>)
    println(longs3 is Array<Int>)

    println(longs1[1])

    val evenNumbers = Array(21) { i -> i * 2 }
    for (number in evenNumbers) println(number)

    val moreNumbers = Array(100) { i -> i }
    val allZeros = Array(10) { 0 }

    var array1: Array<Int>
    array1 = arrayOf(1, 2, 3)
    array1.forEach { println(it) }

    val anyArray = arrayOf(1L, 2, 'c', BigDecimal(4.234), "five")
    anyArray.forEach { println(it) }

    val intArray = intArrayOf(1, 4, 90, 422, 4)
    JavaUtils.printNumbers(array1.toIntArray())
    JavaUtils.printNumbers(intArray)

    val defaultIntArray = IntArray(5)
    JavaUtils.printNumbers(defaultIntArray)
    JavaUtils.printChars(CharArray(5))

    val defaultIntTypedArray = defaultIntArray.toTypedArray()
    defaultIntTypedArray.forEach { println(it) }
}