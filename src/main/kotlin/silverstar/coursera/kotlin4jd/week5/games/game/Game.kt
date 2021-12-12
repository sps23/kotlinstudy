package silverstar.coursera.kotlin4jd.week5.games.game

import silverstar.coursera.kotlin4jd.week5.board.Direction

interface Game {
    fun initialize()
    fun canMove(): Boolean
    fun hasWon(): Boolean
    fun processMove(direction: Direction)
    operator fun get(i: Int, j: Int): Int?
}
