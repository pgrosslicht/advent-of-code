package days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day6Test {
    @Test
    fun testPart1() {
        assertEquals(365131, Day6().partOne())
    }

    @Test
    fun testPart2() {
        assertEquals(1650309278600, Day6().partTwo())
    }
}
