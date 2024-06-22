package BaekJoon.no1822_차집합

fun main() = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }
    val a = readLine().split(" ").map { it.toInt() }.toIntArray()
    val b = readLine().split(" ").map { it.toInt() }.toHashSet()
    val sb = StringBuilder()

    val elems = a.filter { !b.contains(it) }.toIntArray().sorted()
    sb.append("${elems.size}\n")
    elems.forEach { sb.append("$it ") }

    print(sb)
}
