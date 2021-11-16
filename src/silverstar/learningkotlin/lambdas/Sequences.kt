package silverstar.learningkotlin.lambdas

fun main() {

    // sequence is like a stream in Scala
    // use sequence for large data sets with evaluation one by one
    val immutableMap =
        mapOf<Int, Car>(
            1 to Car("blue", "Toyota", 2015),
            2 to Car("red", "BMW", 2012),
            3 to Car("black", "Honda", 2011),
            4 to Car("black", "Ford", 2016)
        )

    println(immutableMap.asSequence().filter { it.value.model == "Ford" }.map { it.value.color })

    val names = listOf("Tom", "Adam", "Joe", "Jane")
    val result1 =
        names
            .asSequence()
            .filter {
                println("filtering $it")
                it[0] == 'J'
            }
            .map {
                println("mapping $it")
                it.uppercase()
            }
            .toList() // this is terminal operation, we evaluate teh sequence here
    println(result1)

    val result2 =
        names
            .asSequence()
            .filter {
                println("filtering $it")
                it.startsWith('J')
            }
            .map {
                println("mapping $it")
                it.lowercase()
            }
            .find { it.endsWith('e') }
    println(result2)
}
