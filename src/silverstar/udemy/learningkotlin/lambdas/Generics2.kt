package silverstar.udemy.learningkotlin.lambdas

fun main() {

    val ints = listOf(1, 2, 3, 4)
    val shorts = listOf<Short>(10, 20, 30, 40)
    val floatsNullable: List<Float?> = listOf(1.23f, 5.44f, 6.24f)

    convertToInt(ints)
    convertToInt(shorts)
    convertToInt(floatsNullable)

    append(StringBuilder("Str1"), StringBuilder("Str2"))

    printCollectionNN(ints)
    printCollectionNN(shorts)
    // printCollectionNN(floatsNullable) will not compile
    printCollectionN(floatsNullable)
    printCollectionN(ints)

    // type erasure testing
    val strings = listOf("aa", "bb", "cc")
    val anys: List<Any> = listOf("aa", "bb", "cc")

    // this check is useless but compiles
    if (strings is List<String>) {
        println(strings.joinToString("; "))
    }
    // if(anys is List<String>) this check will not compile
    // we can use start projection
    if (anys is List<*>) {
        println("This is List")
        // we can use casting using 'as' operator
        val strList = anys as List<String>
        println(strList.map { it.uppercase() }.joinToString(", "))
        // val intList = anys as List<Int> // this  will fail ClassCastException in runtime
    }
}

// if 'T' has no upper bound it is by default 'Any'
// 'T' without upper bound can be applied to both Nullable and NonNullable types
// to restrict to NonNullable restrict with 'Any'
fun <T : Any> printCollectionNN(collection: List<T>) {
    for (item in collection) {
        println(item)
    }
}

fun <T> printCollectionN(collection: List<T>) {
    for (item in collection) {
        println(item)
    }
}

// by specifying upper bound you have to specify Nullability
fun <T : Number?> convertToInt(numbers: List<T>) {
    for (n in numbers) {
        println(n?.toInt())
    }
}

fun <T> append(a: T, b: T) where T : CharSequence, T : Appendable {
    println("Result is ${a.append(b)}")
}

// Generic type in collections is removed in JVM by erasure
// we cannot make a pattern match on collection generic type