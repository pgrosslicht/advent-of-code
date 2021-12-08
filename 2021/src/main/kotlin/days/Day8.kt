package days

import Day
import com.google.common.collect.Collections2
import kotlin.math.pow

class Day8 : Day(8) {
  override fun partOne(): Int {
    val easyDigits = setOf(2, 3, 4, 7)

    return dataList.map {
      val split = it.split("|")
      split.last().split(" ")
    }.sumOf { it.count { s -> easyDigits.contains(s.length) } }
  }

  override fun partTwo(): Long {
    val inputs = dataList.map { it.split(" | ").let { s -> s.first().split(" ") to s.last().split(" ") } }
    return inputs.sumOf { input -> Collections2.permutations("abcdefg".toList()).firstNotNullOf { tryPermutation(it, input) } }
  }

  private fun tryPermutation(perm: List<Char>, input: Pair<List<String>, List<String>>): Long? {
    if (input.first.any { tryDigit(perm, it) == null }) return null
    return input.second.mapIndexed { i, s -> tryDigit(perm, s)!! * (10L.pow(3-i)) }.sum()
  }

  private fun tryDigit(perm: List<Char>, s: String): Int? {
    return when (s.toList().map { perm[it-'a'] }.sorted().joinToString("")) {
      "ab" -> 1
      "acdfg" -> 2
      "abcdf" -> 3
      "abef" -> 4
      "bcdef" -> 5
      "bcdefg" -> 6
      "abd" -> 7
      "abcdefg" -> 8
      "abcdef" -> 9
      "abcdeg" -> 0
      else -> null
    }
  }
}

private fun Long.pow(i: Int): Long = this.toDouble().pow(i).toLong()


fun main() = Day.mainify(Day8::class)
