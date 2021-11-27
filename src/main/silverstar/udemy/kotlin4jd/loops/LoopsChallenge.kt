package silverstar.udemy.kotlin4jd.loops

fun main() {

    val range1 = 5..50 step 5
    //    println(range1.joinToString("\n"))

    //    for (i in 5..50 step 5) println(i)
    //    for (i in -50..50) println(i)

    println(fib(15).joinToString("; "))
    println(fib(25).joinToString("; "))

    // Modify the following code so that it prints the following,
    // each number on a separate line
    // 1, 11, 100, 99, 98, 2
    for (i in 1..5) {
        println(i)
        if (i == 2) break
        for (j in 11..20) {
            println(j)
            for (k in 100 downTo 90) {
                println(k)
                if (k == 98) break
            }
            break
        }
    }

    // Declare a variable called num (int) and assign it whatever you want

    // Declare a variable called dnum (double) and assign it as follows:
    // if num > 100, assign dnum -234.567
    // if num < 100, assign dnum 4444.555
    // if num == 100, assign dnum 0.0
    // do all of the above (declaring dnum and assigning // it) in one statement/expression

    // Then print the value of dnum - separate statement
    val num = 24
    val dnum =
        when {
            num < 100 -> -234.567
            num > 100 -> 4444.555
            else -> 0.0
        }
    println(dnum)
}

// print first 'n' numbers in Fibonacci sequence
fun fib(howMany: Int): List<Int> {
    var twoBefore = 0
    var oneBefore = 1
    val v: List<Int> =
        listOf(twoBefore, oneBefore) +
                (1..(howMany - 2)).map {
                    val current = oneBefore + twoBefore
                    twoBefore = oneBefore
                    oneBefore = current
                    current
                }
    return v
}
