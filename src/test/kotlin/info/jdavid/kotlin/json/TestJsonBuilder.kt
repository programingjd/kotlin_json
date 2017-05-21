package info.jdavid.kotlin.json

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class TestJsonBuilder {

  @Test
  fun testSimple() {
    val json = json(
      "a"("text"),
      "b"(true),
      "c"(2),
      "d"(),
      "e"(null),
      "f"(1, 2, 3, 4)
    )
    assertEquals(6, json.size)
    val a = json["a"]
    assertEquals("text", a)
    val b = json["b"]
    assertEquals(true, b)
    val c = json["c"]
    assertEquals(2, c)
    val d = json["d"]
    assertEquals(emptyMap<String, Any?>(), d)
    val e = json["e"]
    assertNull(e)
    val f = json["f"]
    assertEquals(listOf(1, 2, 3, 4), f)
  }

  @Test
  fun testNested() {
    val json = json(
      "lvl1"(
        "lvl2"(
          "lvl3"()
        )
      )
    )
    assertEquals(1, json.size)

    @Suppress("UNCHECKED_CAST")
    val lvl1 = json["lvl1"] as Map<String, Any?>
    assertEquals(1, lvl1.size)

    @Suppress("UNCHECKED_CAST")
    val lvl2 = lvl1["lvl2"] as Map<String, Any?>
    assertEquals(1, lvl2.size)

    @Suppress("UNCHECKED_CAST")
    val lvl3 = lvl2["lvl3"] as Map<String, Any?>
    assertEquals(0, lvl3.size)
  }

  @Test
  fun testMixedList() {
    val json = json(
      "mixed"(
        "a", 1, true, null
      )
    )
    assertEquals(1, json.size)
    @Suppress("UNCHECKED_CAST")
    val mixed = json["mixed"] as List<Any?>
    assertEquals(4, mixed.size)
    assertEquals("a", mixed[0])
    assertEquals(1, mixed[1])
    assertEquals(true, mixed[2])
    assertNull(mixed[3])
  }

  @Test
  fun testLists() {
    val json = json(
      "list"(1, 1, 2, 2),
      "set"(setOf(1, 2, 3, 4)),
      "iterator"(listOf(1, 1, 2, 3).iterator()),
      "enumeration"(Collections.enumeration(mutableListOf(1, 2, 3, 4)))
    )
    assertEquals(4, json.size)
    val list = json["list"]
    assertEquals(listOf(1, 1, 2, 2), list)
    val set = json["set"]
    assertEquals(listOf(1, 2, 3, 4), set)
    val iterator = json["iterator"]
    assertEquals(listOf(1, 1, 2, 3), iterator)
    val enumeration = json["enumeration"]
    assertEquals(listOf(1, 2, 3, 4), enumeration)
  }

}
