package silverstar.learningkotlin.lambdas

import java.math.BigDecimal

fun main() {

    val listString = mutableListOf("Hello")
    listString.add("World")
    printCollectionString(listString)

    val listBD = mutableListOf(BigDecimal(2.45), BigDecimal(-5.43))
    printCollectionG(listBD)
    printCollectionG(listString)

    listBD.printCollection()
    listString.printCollection()
}

fun printCollectionString(collection: List<String>) {
    for (item in collection) {
        println(item)
    }
}

fun <T> printCollectionG(collection: List<T>) {
    for (item in collection) {
        println(item)
    }
}

// generic extension function
fun <T> List<T>.printCollection() {
    for (item in this) {
        println(item)
    }
}
