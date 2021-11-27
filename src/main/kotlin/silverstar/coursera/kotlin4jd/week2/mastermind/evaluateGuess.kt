package silverstar.coursera.kotlin4jd.week2.mastermind

const val CodeLength = 4

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    fun countMatching(s: String, g: String) =
        s.zip(g).fold(0) { acc, pair -> if (pair.first == pair.second) acc + 1 else acc }

    fun countNotMatching(s: String, g: String) =
        s.toList()
            .fold(g.toMutableList()) { acc, fromS ->
                acc.remove(fromS)
                acc
            }
            .size

    if (secret == guess) {
        return Evaluation(CodeLength, 0)
    } else {
        val rightPositions = countMatching(secret, guess)
        val wrongLetters = countNotMatching(secret, guess)
        val wrongPositions = CodeLength - wrongLetters - rightPositions
        return Evaluation(rightPositions, wrongPositions)
    }
}
