package silverstar.udemy.learningkotlin.lambdas

fun main() {

    // collections in Kotlin are covariant,
    // e.g. you can assign String to collection on Any
    // mutable an immutable collections

    // immutable list
    val seasons = listOf("spring", "summer", "fall", "winter")
    println(seasons.javaClass)
    val emptyListStr = emptyList<String>()
    println(emptyListStr.javaClass)
    val emptyListForever = listOf<String>()
    println(emptyListForever.javaClass)

    if (emptyListStr.isNotEmpty()) {
        println(emptyListStr[0])
    }

    // list without null values
    val notNullValuesList = listOfNotNull("a", "b", null, "c")
    println(notNullValuesList)

    // mutable list
    val mutableArrayList = arrayListOf("a", "b", "c")
    println(mutableArrayList.javaClass)
    println(mutableArrayList.toString())

    val mutableList = mutableListOf("x", "y", "z")
    println(mutableList.javaClass)
    println(mutableList.toString())

    val colorsArray = arrayOf("blue", "red", "yellow")
    println(listOf(*colorsArray))
    println(colorsArray.toList())
}
