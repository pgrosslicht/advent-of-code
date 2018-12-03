import days.Day1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {
    @Test
    fun testPart1() {
        assertEquals(439, Day1().partOne())
    }

    @Test
    fun testPart2() {
        assertEquals(124645, Day1().partTwo())
    }
}