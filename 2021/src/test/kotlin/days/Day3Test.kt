package days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {
    @Test
    fun testPart1() {
        assertEquals(4160394, Day3().partOne())
    }

    @Test
    fun testPart2() {
        assertEquals(4125600, Day3().partTwo())
    }
}