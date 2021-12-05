package days

import Day
import com.google.common.collect.HashBasedTable

class Day4 : Day(4) {
    override fun partOne(): Int {
        val values = dataList.take(1).single().split(",")
        val boards = dataList.drop(2).chunked(6).map { Bingo(it) }
        for (v in values) {
            boards.singleOrNull { it.mark(v.toInt()) }?.let { return v.toInt() * it.sumUnmarked() }
        }
        return 0
    }

    override fun partTwo(): Int {
        val values = dataList.take(1).single().split(",")
        val boards = dataList.drop(2).chunked(6).map { Bingo(it) }
        val lastBoards: MutableList<Bingo> = mutableListOf()
        var lastWinningValue: Int = 0
        for (v in values) {
            val winningBoards = boards.filter { it.mark(v.toInt()) }
            if (winningBoards.isNotEmpty()) lastWinningValue = v.toInt()
            lastBoards.addAll(winningBoards)
        }
        return lastBoards.last().sumUnmarked() * lastWinningValue
    }

    class Bingo(private val lines: List<String>) {
        private val table: HashBasedTable<Int, Int, Cell> = HashBasedTable.create(5, 5)
        private var won: Boolean = false

        init {
            lines.filter { it.isNotEmpty() }.also { check(it.size == 5) }.forEachIndexed { row, s ->
                s.split(" ").filter { it.isNotEmpty() }.also { check(it.size == 5) }
                    .forEachIndexed { column, x -> table.put(row, column, Cell(x.toInt())) }
            }
        }

        fun mark(value: Int): Boolean {
            if (won) return false
            val row = table.rowMap().entries.indexOfFirst { it.value.containsValue(Cell(value)) }
            if (row == -1) return false
            val column = table.row(row).entries.indexOfFirst { it.value == Cell(value) }
            table.get(row, column)!!.marked = true
            val won = table.row(row).values.all { it.marked } || table.column(column).values.all { it.marked }
            if (won) this.won = true
            return won
        }


        fun sumUnmarked(): Int = table.values().filter { !it.marked }.sumOf { it.value }
    }

    data class Cell(val value: Int, var marked: Boolean = false)
}

fun main() = Day.mainify(Day4::class)

