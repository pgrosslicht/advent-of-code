package days

import Day

class Day1 : Day(1) {
    override fun partOne(): Int = dataList.map { it.toInt() }.windowed(2).count { it[0] < it[1] }

    override fun partTwo(): Int = dataList.asSequence().map { it.toInt() }
        .windowed(3).map { it.sum() }.windowed(2).count { it[0] < it[1] }
}

fun main() = Day.mainify(Day1::class)

