package days

import Day

public class Day3 : Day(3) {
    public override fun partOne(): Int = Regex("mul\\(\\d{1,3},\\d{1,3}\\)").findAll(dataString).sumOf {
        val (a, b) = it.value.drop(4).dropLast(1).split(",").map { it.toInt() }
        a * b
    }

    override fun partTwo(): Any? {
        val matches = Regex("((do\\(\\)|don't\\(\\))|mul\\(\\d{1,3},\\d{1,3}\\))").findAll(dataString)
        var enabled = true
        var sum = 0
        for (match in matches) {
            if (match.value.equals("do()")) {
                enabled = true
            } else if (match.value.equals("don't()")) {
                enabled = false
            } else if (enabled) {
                val (a, b) = match.value.drop(4).dropLast(1).split(",").map { it.toInt() }
                sum += a * b
            }
        }
        return sum
    }
}

public fun main() = Day.mainify(Day3::class)
