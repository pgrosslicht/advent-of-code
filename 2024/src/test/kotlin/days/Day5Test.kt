package days

import kotlin.Unit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit

public class Day5Test {
  @Test
  public fun testPart1(): Unit {
    assertEquals(5762, Day5().partOne())
  }

  @Test

  public fun testPart2(): Unit {
    assertEquals(4130, Day5().partTwo())
  }
}
