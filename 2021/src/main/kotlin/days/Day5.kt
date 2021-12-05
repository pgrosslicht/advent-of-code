package days

import Day
import com.google.common.collect.HashBasedTable
import kotlin.math.sign

class Day5 : Day(5) {
    private val regex = Regex("^((\\d*),(\\d*))\\s->\\s((\\d*),(\\d*))\$")
    private val lines =
        dataList.filter { it.isNotEmpty() }.mapNotNull { regex.matchEntire(it) }.map { it.destructured }.map {
            Line(
                Point(it.component2().toInt(), it.component3().toInt()),
                Point(it.component5().toInt(), it.component6().toInt())
            )
        }

    override fun partOne(): Int {
        return Map(lines).overlapping()
    }

    override fun partTwo(): Int {
        return Map(lines, true).overlapping()

    }


    class Map(private val lines: List<Line>, val diagonal: Boolean = false) {
        private val table: HashBasedTable<Int, Int, Int> = HashBasedTable.create()

        init {
            lines.forEach { mark(it) }
            //print()
        }


        private fun mark(line: Line) {
            line.forEachPoint(diagonal) { p -> table.put(p.x, p.y, table.get(p.x, p.y).let { it?.plus(1) ?: 1 }) }
        }

        fun overlapping(): Int = table.values().count { it >= 2 }

        fun print() {
            val rows = table.rowMap().maxOf { it.key }
            val columns = table.columnMap().maxOf { it.key }
            (0..rows).forEach { y ->
                (0..columns).forEach { x ->
                    print(table.get(x, y) ?: ".")
                }
                println()
            }
        }
    }

    data class Line(val p1: Point, val p2: Point) {

        private fun points(withDiagonals: Boolean): Set<Point> {
            if (withDiagonals || p1.x == p2.x || p1.y == p2.y) {
                val dx = (p2.x - p1.x).sign
                val dy = (p2.y - p1.y).sign
                val set = mutableSetOf(p2)
                var x = p1.x
                var y = p1.y
                while (x != p2.x || y != p2.y) {
                    set.add(Point(x, y))
                    x += dx
                    y += dy
                }
                return set
            }
            return setOf()
        }

        fun forEachPoint(withDiagonals: Boolean = false, f: (Point) -> Unit) = points(withDiagonals).forEach(f)
    }

    data class Point(val x: Int, val y: Int)
}

fun main() = Day.mainify(Day5::class)

