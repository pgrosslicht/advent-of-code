package days

import Day

class Day3 : Day(3) {
    override fun partOne(): Int {
        val map =
            dataList.flatMap { it.mapIndexed { index, c -> index to c } }.groupingBy { it }.eachCount().entries.groupBy(
                { it.key.first }) { it.key.second to it.value }
        val gamma = map.values.map { if (it[0].second > it[1].second) it[0].first else it[1].first }
            .joinToString(separator = "")
        val epsilon = gamma.map { if (it == '1') '0' else '1' }.joinToString(separator = "")
        return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
    }

    override fun partTwo(): Int {
        tailrec fun findNumber(input: List<String>, filter: (Int, Int) -> Boolean, position: Int = 0): List<String> {
            val ones = input.count { it[position].digitToInt() == 1 }
            val zeroes = input.size - ones
            val mostCommonOrOne = if (ones >= zeroes) 1 else 0
            val filtered = input.filter { filter(it[position].digitToInt(), mostCommonOrOne) }
            return if (filtered.size == 1) filtered else findNumber(filtered, filter, position + 1)
        }

        val oxygen = findNumber(dataList, { digit, mostCommonOrOne -> digit == mostCommonOrOne }).single().toInt(2)
        val co2 = findNumber(dataList, { digit, mostCommonOrOne -> digit != mostCommonOrOne }).single().toInt(2)
        return oxygen * co2
    }

}

fun main() = Day.mainify(Day3::class)

