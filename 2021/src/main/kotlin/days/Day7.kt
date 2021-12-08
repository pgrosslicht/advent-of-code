package days

import Day
import com.google.common.math.Quantiles
import kotlin.math.abs

class Day7 : Day(7) {
    override fun partOne(): Int {
        val inputs = dataString.split(",").map { it.toInt() }
        val target = Quantiles.median().compute(*inputs.toIntArray()).toInt()
        return inputs.sumOf { abs(target - it) }
    }

    override fun partTwo(): Int {
        val inputs = dataString.split(",").map { it.toInt() }
        val mean = inputs.average().toInt()

        return (mean - 1..mean + 1).minOf { target -> inputs.sumOf { sumBetween(abs(target - it)) } }
    }

    private fun sumBetween(steps: Int): Int = (steps * (steps + 1)) / 2
}

fun main() = Day.mainify(Day7::class)
