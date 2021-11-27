package silverstar.udemy.kotlin4jd.lambdas

fun main() {

    val immutableMap: Map<Int, Car> =
        mapOf(
            1 to Car("a", "Toyota", 2015),
            2 to Car("b", "Toyota", 2019),
            3 to Car("c", "Ford", 2017),
            4 to Car("d", "Honda", 2019),
        )

    val mutableMap: MutableMap<String, Car> =
        mutableMapOf(
            "a1" to Car("a", "Toyota", 2015),
            "a2" to Car("b", "Toyota", 2019),
            "a3" to Car("c", "Ford", 2017),
            "a4" to Car("d", "Honda", 2019),
        )

    println(immutableMap.javaClass)
    println(immutableMap)

    println(mutableMap.javaClass)
    println(mutableMap)
    mutableMap.put("b1", Car("e", "Audi", 2011))
    mutableMap["c1"] = Car("g", "Ferrari", 2021)
    println(mutableMap)

    // destructuring a 'Pair'
    val pair = Pair(10, "ten")
    val (p1, p2) = pair
    println(listOf(pair, p1, p2))

    // destructuring map
    for (car in mutableMap) {
        println(listOf(car.key, car.value))
    }
    for ((k, v) in mutableMap) {
        println(listOf(k, v))
    }

    // deconstructing data class 'Car'
    val car = Car("blue", "Corvette", 1959)
    val (color, model, year) = car
    println(listOf(color, model, year))

    // deconstructing class 'Car'
    val carC = CarC("blue", "Corvette", 1959)
    val (colorC, modelC, yearC) = carC
    println(listOf(colorC, modelC, yearC))
}

class CarC(val color: String, val model: String, val year: Int) {

    operator fun component1() = color
    operator fun component2() = model
    operator fun component3() = year
}
