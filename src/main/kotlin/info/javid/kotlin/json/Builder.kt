package info.javid.kotlin.json

import java.util.*


operator fun String.invoke(s: CharSequence?): Pair<String, String?> {
  return this to s?.toString()
}

operator fun String.invoke(b: Boolean): Pair<String, Boolean> {
  return this to b
}

operator fun String.invoke(n: Number): Pair<String, Number> {
  return this to n
}

operator fun String.invoke(i: Iterable<Any?>): Pair<String, List<Any?>> {
  return this to i.toMutableList()
}

operator fun String.invoke(i: Iterator<Any?>): Pair<String, List<Any?>> {
  return this to i.asSequence().toMutableList()
}

operator fun String.invoke(e: Enumeration<out Any?>): Pair<String, List<Any?>> {
  return this to e.asSequence().toMutableList()
}

operator fun String.invoke(vararg entries: Pair<String, Any?>): Pair<String, Map<String, Any?>> {
  val map = LinkedHashMap<String, Any?>(entries.size)
  for ((k, v) in entries) {
    map.put(k, v)
  }
  return this to map
}

operator fun String.invoke(first: Any?, vararg list: Any?): Pair<String, List<Any?>> {
  return this to mutableListOf(first, *list)
}

fun json(vararg entries: Pair<String, Any?>): LinkedHashMap<String, Any?> {
  val map = LinkedHashMap<String, Any?>(entries.size)
  for ((k, v) in entries) {
    map.put(k, v)
  }
  return map
}
