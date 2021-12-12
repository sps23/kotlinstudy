package silverstar.coursera.kotlin4jd.week5.board

import silverstar.coursera.kotlin4jd.week5.board.Direction.*

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

    override fun Cell.getNeighbour(direction: Direction): Cell? =
        when (direction) {
            UP -> cells[Pair(i - 1, j)]
            DOWN -> cells[Pair(i + 1, j)]
            LEFT -> cells[Pair(i, j - 1)]
            RIGHT -> cells[Pair(i, j + 1)]
        }
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

    override fun any(predicate: (T?) -> Boolean): Boolean = cells.any { (_, v) -> predicate(v) }

    override fun all(predicate: (T?) -> Boolean): Boolean = cells.all { (_, v) -> predicate(v) }
}

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)

fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImp(width)

