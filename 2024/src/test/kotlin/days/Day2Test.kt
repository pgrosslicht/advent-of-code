package days

import kotlin.Unit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

public class Day2Test {
  @Test
  public fun testPart1(): Unit {
    assertEquals(202, Day2().partOne())
  }

  @Test
  public fun testPart2(): Unit {
    assertEquals(271, Day2().partTwo())
  }
}
