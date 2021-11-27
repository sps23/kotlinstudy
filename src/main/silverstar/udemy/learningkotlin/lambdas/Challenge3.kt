package silverstar.udemy.learningkotlin.lambdas

fun main() {

    // Maps
    val joe = Person("Joe", "Jones", 45)
    val jane = Person("Jane", "Smith", 12)
    val mary = Person("Mary", "Wilson", 70)
    val john = Person("John", "Adams", 32)
    val jean = Person("Jean", "Smithson", 65)

    val (fName, lName, age) = joe
    println("$fName, $lName, age $age")

    println(listOf(joe, mary).groupBy { it.lastName })

    val people =
        mapOf(
            joe.lastName to joe,
            jane.lastName to jane,
            mary.lastName to mary,
            john.lastName to john,
            jean.lastName to jean
        )

    println(people)

    // count
    println(people.count { it.key.startsWith("S") })
    println(people.count { it.value.lastName.endsWith("n") })

    // map
    println(people.map { (_, v) -> Pair(v.firstName, v.lastName) })
    println(people.map { Pair(it.value.firstName, it.value.age) })
    println(people.map { it.value.firstName }.zip(people.map { it.value.age }))

    // also
    people.values.map { p -> "${p.firstName} is ${p.age} years old" }.also {
        println(it.joinToString("\n"))
    }

    // Lists
    val ints1 = listOf(1, 4, 9, 15, 33)
    val ints2 = listOf(4, 55 - 83, 22, 101, 15)

    println(ints1.intersect(ints2))
    println(ints1.filter { it in ints2 })
    println(ints1.filter { ints2.contains(it) })

    // Generics
    val regularPaper = Box<Regular>()
    var paper = Box<Paper>()
    paper = regularPaper

}

data class Person(val firstName: String, val lastName: String, val age: Int) {

    // deconstruction
    // operator fun component1() = firstName
    // operator fun component2() = lastName
    // operator fun component3() = age
}

class Box<out T>

open class Paper {}
class Regular : Paper()
class Premium : Paper()
