package silverstar.learningkotlin.lambdas

fun main() {

    val seasons = listOf("spring", "summer", "fall", "summer", "winter")
    val mutableSeasons = seasons.toMutableList()
    val colors = listOf("black", "white", "red", "black", "red")
    val ints = listOf(1, 2, 3, 4, 5)

    println(seasons.last())
    println(seasons.first())
    // view on the original list, but reversed
    println(seasons.asReversed())
    println(seasons.reversed())
    println(seasons.getOrNull(5))
    println(seasons.zip(ints)) // list of pairs
    println(listOf(colors, seasons)) // list of lists
    println(colors + seasons) // concatenated lists
    println(colors.union(seasons)) // no duplicates
    println(colors.distinct()) // no duplicates, returns new list

    mutableSeasons.add("mid-summer")
    println(mutableSeasons)
}
