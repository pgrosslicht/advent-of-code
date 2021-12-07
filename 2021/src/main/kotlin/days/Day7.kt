package days

import Day
import kotlin.math.abs

class Day7 : Day(7) {
  override fun partOne(): Int {
    val inputs = dataString.split(",").map { it.toInt() }
    val min = inputs.minOf { it }
    val max = inputs.maxOf { it }
    return (min..max).minOf { target -> inputs.sumOf { abs(target - it) } }
  }

  override fun partTwo(): Int {
    val inputs = dataString.split(",").map { it.toInt() }
    val min = inputs.minOf { it }
    val max = inputs.maxOf { it }
    return (min..max).minOf { target -> inputs.sumOf { sumBetween(abs(target - it)) } }
  }

  private fun sumBetween(steps: Int): Int = (steps * (steps + 1))/2
}

fun main() = Day.mainify(Day7::class)
