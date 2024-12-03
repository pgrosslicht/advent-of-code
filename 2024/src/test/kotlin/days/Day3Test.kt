package days

import kotlin.Unit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

public class Day3Test {
  @Test
  public fun testPart1(): Unit {
    assertEquals(167090022, Day3().partOne())
  }

  @Test
  public fun testPart2(): Unit {
    assertEquals(89823704, Day3().partTwo())
  }
}
