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

    sampleInput.toBingoGame()
}

data class Cell(val i: Int, val j: Int) {
    override fun toString() = "($i, $j)"
}

interface SquareBoard {
    val width: Int

    fun getCellOrNull(i: Int, j: Int): Cell?
    fun getCell(i: Int, j: Int): Cell

    fun getAllCells(): Collection<Cell>

    fun getRow(i: Int, jRange: IntProgression): List<Cell>
    fun getColumn(iRange: IntProgression, j: Int): List<Cell>
}

interface GameBoard<T> : SquareBoard {

    operator fun get(cell: Cell): T?
    operator fun set(cell: Cell, value: T?)

    fun filter(predicate: (T?) -> Boolean): Collection<Cell>
    fun find(predicate: (T?) -> Boolean): Cell?
}

open class SquareBoardImpl(override val width: Int) : SquareBoard {

    private val cells: MutableMap<Pair<Int, Int>, Cell> = mutableMapOf()

    init {
        for (i in 1..width) {
            for (j in 1..width) {
                cells[Pair(i, j)] = Cell(i, j)
            }
        }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? =
        if (i > width || j > width || i <= 0 || j <= 0) {
            null
        } else {
            cells[Pair(i, j)]
        }

    override fun getCell(i: Int, j: Int): Cell =
        if (i > width || j > width || i <= 0 || j <= 0) {
            throw IllegalArgumentException()
        } else {
            cells[Pair(i, j)]!!
        }

    override fun getAllCells(): Collection<Cell> = cells.values

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> =
        jRange.mapNotNull { getCellOrNull(i, it) }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> =
        iRange.mapNotNull { getCellOrNull(it, j) }
}

class GameBoardImp<T>(width: Int) : GameBoard<T>, SquareBoardImpl(width) {

    private val cells: MutableMap<Cell, T?> = mutableMapOf()

    init {
        for (i in 1..width) {
            for (j in 1..width) {
                cells[getCell(i, j)] = null
            }
        }
    }

    override fun get(cell: Cell): T? = cells.getOrDefault(cell, null)

    override fun set(cell: Cell, value: T?) {
        cells[cell] = value
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> =
        cells.filterValues(predicate).map { it.key }

    override fun find(predicate: (T?) -> Boolean): Cell? = filter(predicate).firstOrNull()
}

interface Game {
    fun initialize()
    fun drawNext()
    fun hasWon(): Boolean
    operator fun get(i: Int, j: Int): Int?
}

class BingoGame(private val draw: List<Int>, private val boards: List<List<Int>>) {}

fun String.toBingoGame(): BingoGame {
    val split: List<String> = this.split("\n\n")
    val draw: List<Int> = split.first().split(',').map { it.trim().toInt() }
    val boards: List<List<Int>> =
        split.drop(1).map { it.trim().split("\\s+".toRegex()).map { it.trim().toInt() } }
    boards.forEach { println(it.joinToString("; ")) }
    return BingoGame(draw, boards)
}
