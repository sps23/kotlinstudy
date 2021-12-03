package silverstar.adventofcode.y2021.day2

/*
--- Day 2: Dive! ---
Now, you need to figure out how to pilot this thing.

It seems like the submarine can take a series of commands like forward 1, down 2, or up 3:

forward X increases the horizontal position by X units.
down X increases the depth by X units.
up X decreases the depth by X units.
Note that since you're on a submarine, down and up affect your depth, and so they have the opposite result of what you might expect.

The submarine seems to already have a planned course (your puzzle input). You should probably figure out where it's going. For example:

forward 5
down 5
forward 8
up 3
down 8
forward 2
Your horizontal position and depth both start at 0. The steps above would then modify them as follows:

forward 5 adds 5 to your horizontal position, a total of 5.
down 5 adds 5 to your depth, resulting in a value of 5.
forward 8 adds 8 to your horizontal position, a total of 13.
up 3 decreases your depth by 3, resulting in a value of 2.
down 8 adds 8 to your depth, resulting in a value of 10.
forward 2 adds 2 to your horizontal position, a total of 15.
After following these instructions, you would have a horizontal position of 15 and a depth of 10. (Multiplying these together produces 150.)

Calculate the horizontal position and depth you would have after following the planned course. What do you get if you multiply your final horizontal position by your final depth?
 */

fun main() {
    val sampleInput = sequenceOf("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")
    fun readInput(): Sequence<String> =
        {}.javaClass.getResourceAsStream("/Dive.txt")?.bufferedReader()?.lineSequence()
            ?: sequenceOf()

    // Part One
    println(pilotResult(sampleInput)) // expected 150
    println(pilotResult(readInput())) // expected 1654760
}

fun pilot(s: Sequence<String>): Position =
    s.map { Movement.from(it) }.fold(Position(0, 0)) { position, move -> position.makeMove(move) }

fun pilotResult(s: Sequence<String>): Int {
    val position = pilot(s)
    return position.horizontal * position.depth
}

data class Position(val horizontal: Int, val depth: Int) {

    fun makeMove(move: Movement): Position =
        when (move.type) {
            MovementType.FORWARD -> this.copy(horizontal = horizontal + move.step)
            MovementType.DOWN -> this.copy(depth = depth + move.step)
            MovementType.UP -> this.copy(depth = depth - move.step)
        }
}

enum class MovementType {
    FORWARD,
    DOWN,
    UP
}

data class Movement(val type: MovementType, val step: Int) {

    companion object {
        fun from(s: String): Movement {
            val (type, step) = s.split(' ')
            return Movement(MovementType.valueOf(type.uppercase()), step.toInt())
        }
    }
}
