package days

import Day
import com.google.common.collect.ImmutableTable
import com.google.common.collect.Table

class Day4 : Day(4) {
    override fun partOne(): Int {
        val table = parse(dataList)
        return table
            .cellSet()
            .flatMap {
                listOf(
                    collect(table, it.rowKey to it.columnKey, 0 to 1, 4),
                    collect(table, it.rowKey to it.columnKey, 1 to 0, 4),
                    collect(table, it.rowKey to it.columnKey, 1 to 1, 4),
                    collect(table, it.rowKey to it.columnKey, 1 to -1, 4),
                )
            }
            .count { it == "XMAS" || it == "SAMX" }
    }

    override fun partTwo(): Int {
        val table = parse(dataList)
        return table
            .cellSet()
            .filter { it.value == "A" }
            .map {
                listOfNotNull(
                    table.get(it.rowKey + 1, it.columnKey + 1),
                    table.get(it.rowKey - 1, it.columnKey - 1),
                    table.get(it.rowKey + 1, it.columnKey - 1),
                    table.get(it.rowKey - 1, it.columnKey + 1),
                )
            }
            .count {
                it == listOf("M", "S", "M", "S") ||
                    it == listOf("S", "M", "M", "S") ||
                    it == listOf("M", "S", "S", "M") ||
                    it == listOf("S", "M", "S", "M")
            }
    }

    private fun collect(
        table: Table<Int, Int, String>,
        start: Pair<Int, Int>,
        direction: Pair<Int, Int>,
        toGo: Int,
    ): String {
        val (x, y) = start
        val (dx, dy) = direction

        if (toGo == 0) return ""
        return table.get(x, y) + collect(table, Pair(x + dx, y + dy), direction, toGo - 1)
    }

    private fun parse(list: List<String>): Table<Int, Int, String> {
        val table = ImmutableTable.builder<Int, Int, String>()
        list.forEachIndexed { i, s -> s.forEachIndexed { j, ch -> table.put(i, j, ch.toString()) } }
        return table.build()
    }
}

fun main() = Day.mainify(Day4::class)
