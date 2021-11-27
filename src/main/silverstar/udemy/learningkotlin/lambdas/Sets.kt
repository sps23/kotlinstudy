package silverstar.udemy.learningkotlin.lambdas

fun main() {

    // immutable set
    val setInts = setOf(10, 15, 33, -22, 14)
    println(setInts.plus(15)) // creates new mutable set
    println(setInts.minus(15))
    println(setInts.minus(100))
    println(setInts.average())
    println(setInts.drop(3))
    println(setInts)

    // mutable set
    val mutableSetInts = mutableSetOf(1, 2, 3, 4, 5, 6)
    println(mutableSetInts.plus(10)) // creates new immutable set
    println(mutableSetInts.drop(2))
    println(mutableSetInts)
}
