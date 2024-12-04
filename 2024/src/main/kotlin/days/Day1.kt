package days

import Day
import kotlin.math.abs

class Day1 : Day(1) {
    override fun partOne(): Int {
        val (left, right) =
            dataList.map { it.split("   ").let { it[0].toInt() to it[1].toInt() } }.unzip()
        return left.sorted().zip(right.sorted()) { l, r -> abs(l - r) }.sum()
    }

    override fun partTwo(): Int {
        val (left, right) =
            dataList.map { it.split("   ").let { it[0].toInt() to it[1].toInt() } }.unzip()
        val rightFrequency = right.groupingBy { it }.eachCount()
        return left.sumOf { it.times(rightFrequency.getOrDefault(it, 0)) }
    }
}

fun main() = Day.mainify(Day1::class)
