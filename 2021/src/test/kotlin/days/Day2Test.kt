package days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {
    @Test
    fun testPart1() {
        assertEquals(2215080, Day2().partOne())
    }

    @Test
    fun testPart2() {
        assertEquals(1864715580, Day2().partTwo())
    }
}