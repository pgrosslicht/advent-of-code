package days

import Day
import java.lang.IllegalArgumentException

class Day2 : Day(2) {
    override fun partOne(): Any = dataList
        .map(this::calculateChecksumParts)
        .fold(Pair(0, 0)) { sum, value ->
            Pair(sum.first + value.first, sum.second + value.second)
        }.let { it.first * it.second }

    /**
     * Returns whether a string has a letter that occurs exactly once or exactly thrice
     */
    private fun calculateChecksumParts(input: String): Pair<Int, Int> = input.asIterable()
        .groupingBy { it }
        .eachCount()
        .let {
            Pair(
                if (it.containsValue(2)) 1 else 0,
                if (it.containsValue(3)) 1 else 0
            )
        }

    override fun partTwo(): Any = findSimilarStrings(dataList)

    private fun findSimilarStrings(input: List<String>): String {
        for (x in input) {
            for (y in input.drop(1)) {
                val differentLetters = x.zip(y).filterNot { it.first == it.second }
                if (differentLetters.size == 1) {
                    return x.filter { it != differentLetters.first().first }
                }
            }
        }
        throw IllegalArgumentException("No two IDs are exactly one character different")
    }
}

fun main() = Day.mainify(Day2::class)