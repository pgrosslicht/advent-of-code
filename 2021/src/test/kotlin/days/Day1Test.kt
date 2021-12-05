package days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {
    @Test
    fun testPart1() {
        assertEquals(1446, Day1().partOne())
    }

    @Test
    fun testPart2() {
        assertEquals(1486, Day1().partTwo())
    }
}