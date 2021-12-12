package silverstar.coursera.kotlin4jd.week5.games.gameOfFifteen

import silverstar.coursera.kotlin4jd.week5.board.Cell
import silverstar.coursera.kotlin4jd.week5.board.Direction
import silverstar.coursera.kotlin4jd.week5.board.GameBoard
import silverstar.coursera.kotlin4jd.week5.board.createGameBoard
import silverstar.coursera.kotlin4jd.week5.games.game.Game

class GameOfFifteen(private val initializer: GameOfFifteenInitializer) : Game {
    private val board: GameBoard<Int?> = createGameBoard(4)

    override fun initialize() {
        board.getAllCells().zip(initializer.initialPermutation).forEach {
            board[it.first] = it.second
        }
    }

    override fun canMove(): Boolean = true

    override fun hasWon(): Boolean = with(board) {
        getAllCells().map { get(it) }.containsAll((1..15).toList())
    }

    override fun processMove(direction: Direction) {
        with(board) {
            val emptyCell: Cell = this.find { it == null }!!
            val neighbour: Cell? = emptyCell.getNeighbour(direction.reversed())
            neighbour?.also {
                this[emptyCell] = board[it]
                this[it] = null
            }
        }
    }

    override fun get(i: Int, j: Int): Int? = board.run { get(getCell(i, j)) }
}
/*
 * Implement the Game of Fifteen (https://en.wikipedia.org/wiki/15_puzzle).
 * When you finish, you can play the game by executing 'PlayGameOfFifteen'.
 */
fun newGameOfFifteen(initializer: GameOfFifteenInitializer = RandomGameInitializer()): Game =
    GameOfFifteen(initializer)

