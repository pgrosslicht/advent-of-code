package days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day5Test {
    @Test
    fun testPart1() {
        assertEquals(4993, Day5().partOne())
    }

    @Test
    fun testPart2() {
        assertEquals(21101, Day5().partTwo())
    }
}