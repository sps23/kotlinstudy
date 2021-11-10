package silverstar.learningkotlin.loops

import java.math.BigDecimal

fun main() {

    // Kotlin way of doing switch statement
    // no way to do 'break' statement
    fun when1(i: Int): Unit =
        when (i) {
            100, 600 -> println("100 or 600") // multiple values match
            in 101..199 -> println("between 101 and 199") // range match
            200 -> println("200")
            300 -> println("300")
            else -> println("does not match anything!")
        }

    when1(200)
    when1(300)
    when1(23)
    when1(100)
    when1(600)
    when1(120)

    println()
    println()

    val obj1: Any = 45
    val obj2: Any = "I am String"
    val obj3 = BigDecimal(12.345)
    val obj4 = obj2

    fun ifIs(obj: Any): Unit =
        if (obj is String) {
            println(obj.uppercase())
        } else if (obj is Int) {
            println(obj - 22)
        } else if (obj is BigDecimal) {
            println(obj.remainder(BigDecimal.TEN))
        } else println("Nothing")

    ifIs(obj1)
    ifIs(obj2)
    ifIs(obj3)
    ifIs(obj4)

    fun whenIs(obj: Any): Int =
        when (obj) {
            is String -> {
                println(obj.uppercase())
                1
            }
            is Int -> {
                println(obj - 22)
                2
            }
            is BigDecimal -> {
                println(obj.remainder(BigDecimal.TEN))
                3
            }
            else -> {
                println("Nothing")
                -1
            }
        }

    println()

    println(whenIs(obj1))
    println(whenIs(obj2))
    println(whenIs(obj3))
    println(whenIs(obj4))

    Season.printMessage(Season.SPRING)
    Season.printMessage(Season.SUMMER)
    Season.printMessage(Season.AUTUMN)
    Season.printMessage(Season.WINTER)

    fun ifCompare(i: Int): Unit =
        if (i < 50) println("less than 50")
        else if (i > 50) println("greater than 50") else println("equals 50")

    // no argument for 'when' expression
    fun whenCompare(i: Int): Unit =
        when {
            i < 50 -> println("$i is less than 50")
            i > 50 -> println("$i is greater than 50")
            else -> println("$i equals 50")
        }

    ifCompare(21)
    whenCompare(123)
    ifCompare(50)
    whenCompare(50)
}

enum class Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;

    companion object {
        fun printMessage(s: Season): Unit =
            when (s) {
                SPRING -> println("Flowers are blooming")
                SUMMER -> println("It is hot")
                AUTUMN -> println("Leave are falling")
                WINTER -> println("It is cold")
                // pattern match is exhaustive, no need for 'else' case
            }
    }
}
