package silverstar.coursera.kotlin4jd.week2.mastermind

import kotlin.math.min

fun evaluateGuessF(secret: String, guess: String): Evaluation {

    val rightPositions = secret.zip(guess).count { it.first == it.second }
    val commonLetters = "ABCDEF".sumOf { ch -> min(secret.count { ch == it }, guess.count { ch == it }) }
    return Evaluation(rightPositions, commonLetters - rightPositions)
}

fun main() {
    val result = Evaluation(rightPosition = 1, wrongPosition = 1)
    evaluateGuessF("BCDF", "ACEB") eq result
    evaluateGuessF("AAAF", "ABCA") eq result
    evaluateGuessF("ABCA", "AAAF") eq result
}

infix fun <T> T.eq(other: T) {
    if (this == other) println("OK") else println("Error: $this != $other")
}
