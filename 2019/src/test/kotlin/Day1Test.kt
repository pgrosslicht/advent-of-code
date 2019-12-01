import days.Day1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {
    @Test
    fun testPart1() {
        assertEquals(3154112.0, Day1().partOne())
    }

    @Test
    fun testPart2() {
        assertEquals(4728317.0, Day1().partTwo())
    }
}