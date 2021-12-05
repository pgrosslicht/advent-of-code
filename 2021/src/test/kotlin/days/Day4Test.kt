package days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day4Test {
    @Test
    fun testPart1() {
        assertEquals(71708, Day4().partOne())
    }

    @Test
    fun testPart2() {
        assertEquals(34726, Day4().partTwo())
    }
}