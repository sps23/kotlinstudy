package silverstar.coursera.kotlin4jd.week5.games.gameOfFifteen

import java.util.*

interface GameOfFifteenInitializer {
    /*
     * Even permutation of numbers 1..15
     * used to initialize the first 15 cells on a board.
     * The last cell is empty.
     */
    val initialPermutation: List<Int>
}

class RandomGameInitializer : GameOfFifteenInitializer {
    /*
     * Generate a random permutation from 1 to 15.
     * `shuffled()` function might be helpful.
     * If the permutation is not even, make it even (for instance,
     * by swapping two numbers).
     */
    override val initialPermutation by lazy {
        val init = (1..15).shuffled()
        if(isEven(init)) init else {
            Collections.swap(init, 0, 1)
            init
        }
    }
}

