package days

import Day

class Day3 : Day(3) {
    private val claims: List<Claim> by lazy {
        inputList.map { Claim.parse(it) }
    }

    override fun partOne(): Any = claims
            .flatMap { it.area }
            .groupingBy { it }
            .eachCount()
            .count { it.value > 1 }

    override fun partTwo(): Any {
        val cloth = mutableMapOf<Pair<Int, Int>, Int>()
        val uncovered = claims.map { it.id }.toMutableSet()
        claims.forEach { claim ->
            claim.area.forEach { spot ->
                val found = cloth.getOrPut(spot) { claim.id }
                if (found != claim.id) {
                    uncovered.remove(found)
                    uncovered.remove(claim.id)
                }
            }
        }
        return uncovered.first()
    }


    data class Claim(val id: Int, val left: Int, val top: Int, val width: Int, val height: Int) {
        val area: List<Pair<Int, Int>> by lazy {
            (left until width + left).flatMap { w ->
                (top until height + top).map { h ->
                    Pair(w, h)
                }
            }
        }

        companion object {
            private val pattern = """^#(\d+) @ (\d+),(\d+): (\d+)x(\d+)$""".toRegex()
            fun parse(input: String): Claim {
                return pattern.find(input)?.let {
                    val (id, left, top, w, h) = it.destructured
                    Claim(id.toInt(), left.toInt(), top.toInt(), w.toInt(), h.toInt())
                } ?: throw IllegalArgumentException("Cannot parse $input")
            }
        }
    }
}