package days

import Day
import kotlin.math.abs

public class Day2 : Day(2) {
    public override fun partOne(): Int = dataList.count { isSafe(parse(it)) }

    public override fun partTwo(): Int = dataList.count { isSafeRemovable(it) }

    private fun parse(report: String): List<Int> = report.split(" ").map { it.toInt() }

    private fun isSafe(levels: List<Int>): Boolean {
        val safeDifference = levels.zipWithNext { a, b -> abs(a - b) >= 1 && abs(a - b) <= 3 }.all { it }
        val isIncreasing = levels.zipWithNext { a, b -> a < b }.all { it }
        val isDecreasing = levels.zipWithNext { a, b -> a > b }.all { it }

        return safeDifference && (isIncreasing || isDecreasing)
    }

    private fun isSafeRemovable(report: String): Boolean {
        val levels = report.split(" ").map { it.toInt() }
        if (isSafe(levels)) return true

        return (0..levels.size).any { isSafe(levels.filterIndexed { index, _ -> index != it }) }
    }
}


public fun main() = Day.mainify(Day2::class)
