import days.Day3
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {
    @Test
    fun testPart1() {
        assertEquals(109143, Day3().partOne())
    }

    @Test
    fun testPart2() {
        assertEquals(506, Day3().partTwo())
    }
}