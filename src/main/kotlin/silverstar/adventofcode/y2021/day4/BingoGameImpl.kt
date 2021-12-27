package silverstar.adventofcode.y2021.day4

/*
--- Day 4: Giant Squid ---
You're already almost 1.5km (almost a mile) below the surface of the ocean, already so deep that you can't see any sunlight. What you can see, however, is a giant squid that has attached itself to the outside of your submarine.

Maybe it wants to play bingo?

Bingo is played on a set of boards each consisting of a 5x5 grid of numbers. Numbers are chosen at random, and the chosen number is marked on all boards on which it appears. (Numbers may not appear on all boards.) If all numbers in any row or any column of a board are marked, that board wins. (Diagonals don't count.)

The submarine has a bingo subsystem to help passengers (currently, you and the giant squid) pass the time. It automatically generates a random order in which to draw numbers and a random set of boards (your puzzle input). For example:

7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1

22 13 17 11  0
 8  2 23  4 24
21  9 14 16  7
 6 10  3 18  5
 1 12 20 15 19

 3 15  0  2 22
 9 18 13 17  5
19  8  7 25 23
20 11 10 24  4
14 21 16 12  6

14 21 17 24  4
10 16 15  9 19
18  8 23 26 20
22 11 13  6  5
 2  0 12  3  7
After the first five numbers are drawn (7, 4, 9, 5, and 11), there are no winners, but the boards are marked as follows (shown here adjacent to each other to save space):

22 13 17 11  0         3 15  0  2 22        14 21 17 24  4
 8  2 23  4 24         9 18 13 17  5        10 16 15  9 19
21  9 14 16  7        19  8  7 25 23        18  8 23 26 20
 6 10  3 18  5        20 11 10 24  4        22 11 13  6  5
 1 12 20 15 19        14 21 16 12  6         2  0 12  3  7
After the next six numbers are drawn (17, 23, 2, 0, 14, and 21), there are still no winners:

22 13 17 11  0         3 15  0  2 22        14 21 17 24  4
 8  2 23  4 24         9 18 13 17  5        10 16 15  9 19
21  9 14 16  7        19  8  7 25 23        18  8 23 26 20
 6 10  3 18  5        20 11 10 24  4        22 11 13  6  5
 1 12 20 15 19        14 21 16 12  6         2  0 12  3  7
Finally, 24 is drawn:

22 13 17 11  0         3 15  0  2 22        14 21 17 24  4
 8  2 23  4 24         9 18 13 17  5        10 16 15  9 19
21  9 14 16  7        19  8  7 25 23        18  8 23 26 20
 6 10  3 18  5        20 11 10 24  4        22 11 13  6  5
 1 12 20 15 19        14 21 16 12  6         2  0 12  3  7
At this point, the third board wins because it has at least one complete row or column of marked numbers (in this case, the entire top row is marked: 14 21 17 24 4).

The score of the winning board can now be calculated. Start by finding the sum of all unmarked numbers on that board; in this case, the sum is 188. Then, multiply that sum by the number that was just called when the board won, 24, to get the final score, 188 * 24 = 4512.

To guarantee victory against the giant squid, figure out which board will win first. What will your final score be if you choose that board?
 */

fun main() {

    val sampleInput =
        """7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1

22 13 17 11  0
 8  2 23  4 24
21  9 14 16  7
 6 10  3 18  5
 1 12 20 15 19

 3 15  0  2 22
 9 18 13 17  5
19  8  7 25 23
20 11 10 24  4
14 21 16 12  6

14 21 17 24  4
10 16 15  9 19
18  8 23 26 20
22 11 13  6  5
 2  0 12  3  7"""

    println(sampleInput.toBingoGame().play())
}

interface BingoGame {
    fun printGame(): Unit
    fun canDrawNext(): Boolean
    fun drawNext()
    fun hasWon(): Boolean
    fun score(): Int

    fun play(): Int {
        do {
            printGame()
            drawNext()
        } while(!hasWon() && canDrawNext())
//        while (!hasWon() && canDrawNext()) {
//            printGame()
//            drawNext()
//        }
        return if (hasWon()) score() else -1
    }
}

interface BingoBoard {
    val boardSize: Int
    fun printBoard(): Unit
    fun mark(number: Int): BingoBoard
    fun hasWon(): Boolean
    fun sumOfAllUnmarked(): Int
    fun score(lastDrawn: Int): Int = sumOfAllUnmarked() * lastDrawn
}

class BingoBoardImpl(private val board: List<Int>) : BingoBoard {
    override val boardSize = 5
    override fun printBoard() {
        println(board.joinToString("; "))
    }

    override fun mark(number: Int): BingoBoard =
        BingoBoardImpl(board.fold(listOf()) { acc, i -> if (i == number) acc + -i else acc + i })

    private fun wonRow(): Boolean =
        (0 until boardSize).step(boardSize).any {
            board.subList(it, it + boardSize - 1).all { it < 0 }
        }

    private fun wonColumn(): Boolean =
        (0 until boardSize).any { col ->
            (0 until boardSize)
                .map { row ->
                    val index = col + row * boardSize
                    board.get(index)
                }
                .all { it < 0 }
        }

    override fun hasWon(): Boolean {
        println("${wonRow()}; ${wonColumn()}")
        return wonRow() || wonColumn()
    }

    override fun sumOfAllUnmarked(): Int {
        return board.sumOf { if(it > 0) it else 0 }
    }
}

class BingoGameImpl(private val draw: List<Int>, private val boards: List<BingoBoard>, currentNumber: Int? = null) : BingoGame {
    private var currentDraw = draw.toList()
    private var currentBoards = boards.toList()

    override fun printGame() {
        currentBoards.forEach { it.printBoard() }
        println(currentDraw.joinToString("; "))
        println()
    }

    override fun canDrawNext(): Boolean = currentDraw.isNotEmpty()

    override fun drawNext() {
        val number = currentDraw.firstOrNull()
        if (number != null) {
            currentDraw = currentDraw.drop(1)
            currentBoards = currentBoards.map { it.mark(number) }
        }
    }

    override fun hasWon(): Boolean = currentBoards.any { it.hasWon() }

    override fun score(): Int =
        currentBoards.firstOrNull { it.hasWon() }?.score(currentDraw.first()) ?: -1
}

fun String.toBingoGame(): BingoGameImpl {
    val split: List<String> = this.split("\n\n")
    val draw: List<Int> = split.first().split(',').map { it.trim().toInt() }
    val boards: List<List<Int>> =
        split.drop(1).map { it.trim().split("\\s+".toRegex()).map { it.trim().toInt() } }
    //    boards.forEach { println(it.joinToString("; ")) }
    val bingoGame = BingoGameImpl(draw, boards.map { BingoBoardImpl(it) })
    bingoGame.printGame()
    return bingoGame
}
