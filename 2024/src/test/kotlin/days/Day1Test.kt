package days

import kotlin.Unit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

public class Day1Test {
  @Test
  public fun testPart1(): Unit {
    assertEquals(3714264, Day1().partOne())
  }

  @Test
  public fun testPart2(): Unit {
    assertEquals(18805872, Day1().partTwo())
  }
}
