package days

import kotlin.Unit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

public class Day6Test {
  @Test
  public fun testPart1(): Unit {
    assertEquals(4602, Day6().partOne())
  }

  @Test
  public fun testPart2(): Unit {
    assertEquals(1703, Day6().partTwo())
  }
}
