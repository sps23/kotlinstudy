package silverstar.learningkotlin.lambdas

import java.math.BigDecimal

fun main() {

    val mixedList: List<Any> =
        listOf("text", 123, 4.56, BigDecimal(78.9), "error", BigDecimal(142.55))

    val bigDecimals = getElementsOfType<BigDecimal>(mixedList)
    println(bigDecimals.joinToString("; "))

    val strings = getElementsOfType<String>(mixedList)
    println(strings.joinToString("; "))
}

// reification example
// to avoid type erasure we have to declare function to be inline and reify the type 'T'
inline fun <reified T> getElementsOfType(list: List<Any>): List<T> {
    val newList = mutableListOf<T>()
    for (elem in list) {
        if (elem is T) newList.add(elem)
    }
    return newList
}
