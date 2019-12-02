import days.Day2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {
    @Test
    fun testPart1() {
        assertEquals(4090689, Day2().partOne())
    }

    @Test
    fun testPart2() {
        assertEquals(7733, Day2().partTwo())
    }
}