package silverstar.coursera.kotlin4jd.week5.games.gameOfFifteen

/*
* This function should return the parity of the permutation.
* true - the permutation is even
* false - the permutation is odd
* https://en.wikipedia.org/wiki/Parity_of_a_permutation

* If the game of fifteen is started with the wrong parity, you can't get the correct result
*   (numbers sorted in the right order, empty cell at last).
* Thus the initial permutation should be correct.
*/
fun isEven(permutation: List<Int>): Boolean =
    permutation.withIndex().fold(0) { diffCount, i ->
        diffCount + permutation.slice(i.index + 1 until permutation.size).count { i.value > it }
    } % 2 == 0
