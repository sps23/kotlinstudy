package silverstar.udemy.learningkotlin.loops

fun main() {

    // you can create range on any Comperable type
    // range is both inclusive
    val intRange = 1..5
    println(intRange.joinToString(","))

    // for loop
    for (i in 1..10) {
        println(i)
    }

    for (num in 1 until 20 step 5) {
        println(num)
    }

    for (i in 100 downTo 10 step 12) {
        println(i)
    }

    println(32 !in 1..10)

    val charRange = 'a'..'h'
    println(charRange.joinToString(","))

    val stringRange = "ABC".."HIJ"
    println(stringRange.toString())

    println(3 in intRange)
    println('f' in charRange)
    println('x' in charRange)
    println("CCC" in stringRange)
    println("MMMMM" in stringRange)

    val backwardIntRange = 5.downTo(1)
    println(backwardIntRange.joinToString(","))
    println(3 in backwardIntRange)

    val step2Range = (1..10).step(2)
    println(step2Range.joinToString(","))

    val step2ReversedRange = step2Range.reversed()
    println(step2ReversedRange.joinToString(","))

    val seasons = arrayOf("spring", "summer", "fall", "winter")
    for (i in seasons.indices) {
        println("$i: ${seasons[i]}")
    }
    seasons.forEach { println(it) }
    seasons.forEachIndexed { i, v -> println("$i: $v") }

    // breaking loop
    for (i in 1..3) {
        println("i = $i")
        jloop@ for (j in 1..4) {
            println("j = $j")
            for (k in 5..10) {
                println("k = $k")
                // if (k == 7) break@jloop
                if (k == 7) continue@jloop
            }
        }
    }
}
