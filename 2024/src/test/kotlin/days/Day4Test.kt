package days

import kotlin.Unit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

public class Day4Test {
  @Test
  public fun testPart1(): Unit {
    assertEquals(2599, Day4().partOne())
  }

  @Test
  public fun testPart2(): Unit {
    assertEquals(1948, Day4().partTwo())
  }
}
