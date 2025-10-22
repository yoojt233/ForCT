package BaekJoon.no1766_문제집

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { ArrayList<Int>() }
    val degrees = IntArray(n + 1)
    val pq = PriorityQueue<Int>()
    val sb = StringBuilder()

    repeat(m) {
        val (first, last) = readLine().split(" ").map { it.toInt() }

        graph[first].add(last)
        ++degrees[last]
    }

    for (i in 1..n) {
        if (degrees[i] != 0) continue

        pq.add(i)
    }

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        sb.append("$cur ")
        for (next in graph[cur]) {
            --degrees[next]

            if (degrees[next] == 0) pq.add(next)
        }
    }

    println(sb.toString())
}
