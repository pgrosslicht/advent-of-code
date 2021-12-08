package days

import kotlin.Unit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day8Test {
  @Test
  fun testPart1() {
    assertEquals(514, Day8().partOne())
  }

  @Test
  fun testPart2() {
    assertEquals(1012272, Day8().partTwo())
  }
}
