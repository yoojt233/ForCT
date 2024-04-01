package BaekJoon.no10825_국영수

import java.util.PriorityQueue

data class Person(val name: String, val korean: Int, val english: Int, val math: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Person>(compareBy({ -it.korean }, { it.english }, { -it.math }, { it.name }))
    val sb = StringBuilder()

    repeat(n) {
        val (name, korean, english, math) = readLine().split(" ")

        pq.add(Person(name, korean.toInt(), english.toInt(), math.toInt()))
    }

    while (pq.isNotEmpty()) sb.append("${pq.poll().name}\n")
    print(sb)
}
