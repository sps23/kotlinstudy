package silverstar.coursera.kotlin4jd.week3

import silverstar.coursera.kotlin4jd.week3.Gender.FEMALE
import silverstar.coursera.kotlin4jd.week3.Gender.MALE

data class Hero(val name: String, val age: Int, val gender: Gender?)

enum class Gender {
    MALE,
    FEMALE
}

fun main() {

    val heroes =
        listOf(
            Hero("The Captain", 60, MALE),
            Hero("Frenchy", 42, MALE),
            Hero("The Kid", 9, null),
            Hero("Lady Lauren", 29, FEMALE),
            Hero("First Mate", 29, MALE),
            Hero("Sir Stephen", 37, MALE)
        )

    println(heroes.last().name)
    println(heroes.firstOrNull { it.age == 30 }?.name)
    println(heroes.map { it.age }.distinct())
    println(heroes.filter { it.age < 30 })

    val (youngest, oldest) = heroes.partition { it.age < 30 }
    println(youngest)
    println(oldest)

    println(heroes.maxByOrNull { it.age }?.name)
    println(heroes.all { it.age < 50 })
    println(heroes.any { it.gender == FEMALE })

    val mapByAge: Map<Int, List<Hero>> = heroes.groupBy { it.age }
    println(mapByAge)
    val (age, group) = mapByAge.maxByOrNull { (_, group) -> group.size }!!
    println(group)
    println(age)

    val mapByName1: Map<String, Hero> = heroes.associateBy { it.name }
    println(mapByName1["Frenchy"]?.age)
    println(mapByName1.getValue("Frenchy").age)

    val mapByName2 = heroes.associateBy { it.name }
    val unknownHero = Hero("Unknown", 0, null)
    println(mapByName2.getOrElse("unknown") { unknownHero }.age)

    val mapByName3 = heroes.associate { it.name to it.age }
    println(mapByName3.getOrElse("unknown") { 0 })

//    val (first, second) =
//        heroes.flatMap { heroes.map { hero -> it to hero } }.maxByOrNull {
//            it.first.age - it.second.age
//        }!!
    val (first, second) =
        heroes.flatMap { first ->  heroes.map { second -> first to second } }.maxByOrNull {
            it.first.age - it.second.age
        }!!
    println(first)
    println(second)
}
