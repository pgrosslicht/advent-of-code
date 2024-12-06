package utils

import utils.Direction.Companion.UP
import utils.Direction.Companion.DOWN
import utils.Direction.Companion.LEFT
import utils.Direction.Companion.RIGHT

// Origin is top-left corner (0, 0), x grows to the right, y grows down (x, y)
data class Direction(val dx: Int, val dy: Int) {
    operator fun plus(other: Direction) = Direction(dx + other.dx, dy + other.dy)

    companion object {
        val UP = Direction(0, -1)
        val DOWN = Direction(0, 1)
        val LEFT = Direction(-1, 0)
        val RIGHT = Direction(1, 0)
    }

    fun turnRight() = Direction(dy, -dx)
}

val CARDINALS = listOf(UP, RIGHT, DOWN, LEFT)
val DIAGONALS = listOf(UP + RIGHT, RIGHT + DOWN, DOWN + LEFT, LEFT + UP)