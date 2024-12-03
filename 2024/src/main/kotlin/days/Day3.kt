package days

import Day

public class Day3 : Day(3) {
    public override fun partOne(): Int = Regex("mul\\(\\d{1,3},\\d{1,3}\\)").findAll(dataString).sumOf {
        val (a, b) = it.value.drop(4).dropLast(1).split(",").map { it.toInt() }
        a * b
    }

    override fun partTwo(): Int = Regex("((do\\(\\)|don't\\(\\))|mul\\(\\d{1,3},\\d{1,3}\\))")
        .findAll(dataString)
        .fold(Pair(true, 0)) { acc, match ->
            when (match.value) {
                "do()" -> acc.copy(first = true)
                "don't()" -> acc.copy(first = false)
                else -> if (acc.first) {
                    val (a, b) = match.value.drop(4).dropLast(1).split(",").map { it.toInt() }
                    acc.copy(second = acc.second + a * b)
                } else acc
            }
        }.second
}

public fun main() = Day.mainify(Day3::class)
