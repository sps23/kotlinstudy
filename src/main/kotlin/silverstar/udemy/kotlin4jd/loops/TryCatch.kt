package silverstar.udemy.kotlin4jd.loops

import java.lang.RuntimeException

fun main() {

    println(getNumber("123"))
    println(getNumber("0.5"))
    println(getNumberNullable("0.5") ?: -1)
    println(getNumberNullable("0.5") ?: "Cannot print the result")

    // notImplementedYet("test")
}

fun getNumber(s: String): Int =
    try {
        Integer.parseInt(s)
    } catch (e: NumberFormatException) {
        0
    } finally {
        println("finally getNumber($s)") // no value is returned in finally
    }

fun getNumberNullable(s: String): Int? =
    try {
        Integer.parseInt(s)
    } catch (e: NumberFormatException) {
        null
    } finally {
        println("finally getNumber($s)") // no value is returned in finally
    }

// use 'Nothing' when you want to show that fun is not returning anything
fun notImplementedYet(s: String): Nothing = throw RuntimeException()
