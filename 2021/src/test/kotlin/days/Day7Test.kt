package days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day7Test {
    @Test
    fun testPart1() {
        assertEquals(336120, Day7().partOne())
    }

    @Test
    fun testPart2() {
        assertEquals(96864235, Day7().partTwo())
    }
}
