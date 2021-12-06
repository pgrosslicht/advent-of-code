package days

import Day

class Day6 : Day(6) {
    override fun partOne(): Long {
        val school = School(dataString)
        repeat(80) { school.tick() }
        return school.size()
    }

    override fun partTwo(): Long {
        val school = School(dataString)
        repeat(256) { school.tick() }
        return school.size()
    }

    class School(private val input: String) {
        private var map = mutableMapOf<Long, Long>()

        init {
            input.split(",").forEach { map.compute(it.toLong()) { _, v -> v?.plus(1) ?: 1 } }
        }

        fun tick() {
            val ticked = mutableMapOf<Long, Long>()
            map.mapKeysTo(ticked) { it.key - 1 }
            if (ticked[-1] != null) {
                ticked[8] = ticked[-1]!!
                ticked.merge(6, ticked[-1]!!) { old, new -> old + new }
                ticked.remove(-1)
            }
            map = ticked
        }

        fun size() = map.values.sum()
    }
}

fun main() = Day.mainify(Day6::class)
