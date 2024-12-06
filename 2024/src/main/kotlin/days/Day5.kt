package days

import Day

public class Day5 : Day(5) {
    public override fun partOne(): Int {
        val (rules, updates) = dataString.split("\n\n", limit = 2).map { it.lines() }
        val mustBeBefore =
            rules
                .map { it.split("|").let { (x, y) -> x.toInt() to y.toInt() } }
                .groupBy({ it.first }, { it.second })
                .mapValues { (_, v) -> v.toSet() }
        val validUpdates =
            updates.map { it.split(",").map { it.toInt() } }.filter { isValid(it, mustBeBefore) }
        return validUpdates.sumOf { it[it.size / 2] }
    }

    public override fun partTwo(): Int {
        val (rules, updates) = dataString.split("\n\n", limit = 2).map { it.lines() }
        val mustBeBefore =
            rules
                .map { it.split("|").let { (x, y) -> x.toInt() to y.toInt() } }
                .groupBy({ it.first }, { it.second })
                .mapValues { (_, v) -> v.toSet() }
        val invalidUpdates =
            updates.map { it.split(",").map { it.toInt() } }.filterNot { isValid(it, mustBeBefore) }
        val fixedUpdates = invalidUpdates.map { fixUpdate(it, mustBeBefore) }
        return fixedUpdates.sumOf { it[it.size / 2] }
    }

    private tailrec fun fixUpdate(update: List<Int>, mustBeBefore: Map<Int, Set<Int>>): List<Int> {
        val fixed = update.toMutableList()
        for (i in update.indices) {
            val page = update[i]
            val rule = mustBeBefore[page].orEmpty()
            val before = update.subList(0, i).toSet()
            if (rule.any { it in before }) {
                val index = update.indexOfFirst { it in rule }
                fixed[i] = update[index]
                fixed[index] = page
                break
            }
        }
        return if (isValid(fixed, mustBeBefore)) fixed else fixUpdate(fixed, mustBeBefore)
    }

    private fun isValid(update: List<Int>, mustBeBefore: Map<Int, Set<Int>>): Boolean =
        update
            .mapIndexed { index, page ->
                val before = update.subList(0, index).toSet()
                val rule = mustBeBefore[page].orEmpty()
                rule.none { it in before }
            }
            .all { it }
}

public fun main() = Day.mainify(Day5::class)