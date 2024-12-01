package days

import Day
import kotlin.math.abs

public class Day1 : Day(1) {
  public override fun partOne(): Int {
    val (left, right) =
        dataList.map { it.split("   ").let { it[0].toInt() to it[1].toInt() } }.unzip()
    return left.sorted().zip(right.sorted()) { l, r -> abs(l - r) }.sum()
  }

  public override fun partTwo(): Int {
    val (left, right) =
        dataList.map { it.split("   ").let { it[0].toInt() to it[1].toInt() } }.unzip()
    val rightFrequency = right.groupingBy { it }.eachCount()
    return left.sumOf { it.toInt().let { it.times(rightFrequency.getOrDefault(it, 0)) } }
  }
}

public fun main() = Day.mainify(Day1::class)
