package days

import Day

class Day2 : Day(2) {
    override fun partOne(): Any = inputList
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

    override fun partTwo(): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}