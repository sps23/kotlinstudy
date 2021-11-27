package silverstar.udemy.kotlin4jd.lambdas

fun main() {

    val setInts = setOf(10, 15, 19, 5, 3, -22)

    println(setInts.filter { it % 2 != 0 })

    val immutableMap =
        mapOf<Int, Car>(
            1 to Car("blue", "Toyota", 2015),
            2 to Car("red", "Ford", 2016),
            3 to Car("black", "Honda", 2011),
            4 to Car("black", "Ford", 2016)
        )

    println(immutableMap.toSortedMap())

    println(immutableMap.filter { it.value.year == 2015 })
    println(immutableMap.filter { it.value.model == "Ford" }.map { it.value.color })
    println(immutableMap.map { it.value.year })
    println(immutableMap.mapValues { it.value.color })
    println(immutableMap.all { it.value.year >= 2015 })
    println(immutableMap.any { it.value.year >= 2015 })
    println(immutableMap.count { it.value.year >= 2015 })

    val cars = immutableMap.values

    println(cars.find { it.year >= 2016 }) // find first
    println(cars.groupBy { it.model })
    println(cars.sortedBy { it.year })

    val mutableMap = immutableMap.toMutableMap()

    println(mutableMap.filter { it.value.color == "red" })

    val ints = arrayOf(1, 2, 3, 4, 5)
    val add10List: MutableList<Int> = mutableListOf()

    for (i in ints) {
        add10List.add(i + 10)
    }

    println(add10List)
    println(ints.map { it + 10 })
}
