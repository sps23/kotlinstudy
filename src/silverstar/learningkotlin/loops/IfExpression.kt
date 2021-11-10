package silverstar.learningkotlin.loops

fun main() {

    fun lessThan50(i: Int): Boolean = i < 50

    // if expression
    val num1: Int = if (lessThan50(21)) 50 else 100

    println(num1)

    val num2 =
        if (lessThan50(123)) {
            println("less than 50")
            1
        } else {
            println("more than 50")
            10
        }
    println(num2)

    val x = if (true) println("true") else println("false")
    println(x.javaClass.canonicalName)
}
