package days

import Day

class Day2 : Day(2) {
    override fun partOne(): Int = dataList.fold(0 to 0) { acc, s ->
        val splits = s.split(" ")
        val n = splits.last().toInt()
        when (splits.first()) {
            "forward" -> acc.copy(first = acc.first + n)
            "up" -> acc.copy(second = acc.second - n)
            "down" -> acc.copy(second = acc.second + n)
            else -> throw IllegalArgumentException("${splits.first()} not allowed")
        }
    }.let { it.first * it.second }

    override fun partTwo(): Int = dataList.fold(Triple(0, 0, 0)) { acc, s ->
        val splits = s.split(" ")
        val n = splits.last().toInt()
        when (splits.first()) {
            "forward" -> acc.copy(first = acc.first + n, second = acc.second + (n * acc.third))
            "up" -> acc.copy(third = acc.third - n)
            "down" -> acc.copy(third = acc.third + n)
            else -> throw IllegalArgumentException("${splits.first()} not allowed")
        }
    }.let { it.first * it.second }
}

fun main() = Day.mainify(Day2::class)

