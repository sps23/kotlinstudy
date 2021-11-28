package silverstar.coursera.kotlin4jd.week3

fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0) return listOf() // always returns empty list from here
        listOf(it, it)
    }
}

fun duplicateNonZeroFixed(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0) return@flatMap listOf() // lambda with return from label
        listOf(it, it)
    }
}

fun duplicateNonZeroFixed2(list: List<Int>): List<Int> {
    fun duplicateNonZeroElem(e: Int): List<Int> =
        if (e == 0) listOf() else listOf(e, e) // local function
    return list.flatMap(::duplicateNonZeroElem)
}

// anonymous function definition, like lambda
fun duplicateNonZeroFixed3(list: List<Int>): List<Int> =
    list.flatMap(fun(e): List<Int> = if (e == 0) listOf() else listOf(e, e))

fun main() {
    println(duplicateNonZero(listOf(3, 0, 5)))
    println(duplicateNonZeroFixed(listOf(3, 0, 5)))
    println(duplicateNonZeroFixed2(listOf(3, 0, 5)))
    println(duplicateNonZeroFixed3(listOf(3, 0, 5)))
}
