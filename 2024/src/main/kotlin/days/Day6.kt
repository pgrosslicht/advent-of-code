package days

import Day
import com.google.common.collect.HashBasedTable
import com.google.common.collect.ImmutableTable
import com.google.common.collect.Table
import utils.Direction

public class Day6 : Day(6) {
    public override fun partOne(): Int {
        val map =
            ImmutableTable.builder<Int, Int, Entity>()
                .also { builder ->
                    dataList.forEachIndexed { x, line ->
                        line.forEachIndexed { y, ch -> builder.put(x, y, Entity.of(ch)) }
                    }
                }
                .build()

        val start = map.find { it == Entity.GUARD } ?: error("Guard not found")

        return walkUntilObstacle(map, mutableSetOf(), start, Direction.LEFT).size
    }

    public override fun partTwo(): Int {
        val map =
            ImmutableTable.builder<Int, Int, Entity>()
                .also { builder ->
                    dataList.forEachIndexed { x, line ->
                        line.forEachIndexed { y, ch -> builder.put(x, y, Entity.of(ch)) }
                    }
                }
                .build()

        val start = map.find { it == Entity.GUARD } ?: error("Guard not found")

        return map.cellSet()
            .filter { it.value == Entity.EMPTY }
            .count {
                val newMap = HashBasedTable.create(map)
                newMap.put(it.rowKey, it.columnKey, Entity.OBSTACLE)
                walksInLoop(newMap, mutableSetOf(), start, Direction.LEFT)
            }
    }

    tailrec fun walkUntilObstacle(
        map: Table<Int, Int, Entity>,
        visited: MutableSet<Pair<Int, Int>>,
        start: Pair<Int, Int>,
        direction: Direction,
    ): MutableSet<Pair<Int, Int>> {
        visited.add(start)
        val next = map.get(start.first + direction.dx, start.second + direction.dy)
        println(
            "start: $start (${map.get(start.first, start.second)}, direction: $direction, next: $next"
        )

        if (next == null) return visited
        if (next == Entity.OBSTACLE)
            return walkUntilObstacle(map, visited, start, direction.turnRight())
        return walkUntilObstacle(map, visited, start + direction, direction)
    }

    tailrec fun walksInLoop(
        map: Table<Int, Int, Entity>,
        visited: MutableSet<Pair<Direction, Pair<Int, Int>>>,
        start: Pair<Int, Int>,
        direction: Direction,
    ): Boolean {
        visited.add(direction to start)
        val next = map.get(start.first + direction.dx, start.second + direction.dy)

        if (next == null) return false
        if (next == Entity.OBSTACLE) return walksInLoop(map, visited, start, direction.turnRight())
        if (visited.contains(direction to (start + direction))) return true
        return walksInLoop(map, visited, start + direction, direction)
    }

    enum class Entity {
        EMPTY,
        OBSTACLE,
        GUARD;

        companion object {
            fun of(char: Char): Entity =
                when (char) {
                    '.' -> EMPTY
                    '#' -> OBSTACLE
                    '^' -> GUARD
                    else -> throw IllegalArgumentException("Invalid character: $char")
                }
        }
    }
}

private fun <I, V> Table<I, I, V>.find(predicate: (V) -> Boolean): Pair<I, I>? =
    cellSet().find { cell -> predicate(cell.value) }?.let { it.rowKey to it.columnKey }

operator fun Pair<Int, Int>.plus(direction: Direction) =
    first + direction.dx to second + direction.dy

public fun main() = Day.mainify(Day6::class)
