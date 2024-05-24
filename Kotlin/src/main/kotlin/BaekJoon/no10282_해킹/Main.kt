package BaekJoon.no10282_해킹

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val (n, d, c) = readLine().split(" ").map { it.toInt() }
        val graph = Array(n) { ArrayList<Pair<Int, Int>>() }

        repeat(d) {
            val (a, b, cost) = readLine().split(" ").map { it.toInt() }
            graph[b - 1].add(Pair(a - 1, cost))
        }

        val res = dijkstra(n, graph, c - 1)
        sb.append("${res.first} ${res.second}\n")
    }

    print(sb)
}

fun dijkstra(n: Int, graph: Array<ArrayList<Pair<Int, Int>>>, op: Int): Pair<Int, Int> {
    val dist = IntArray(n) { -1 }
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    dist[op] = 0
    pq.add(Pair(op, 0))

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        for (next in graph[cur.first]) {
            if (dist[next.first] == -1 || cur.second + next.second < dist[next.first]) {
                dist[next.first] = cur.second + next.second
                pq.add(Pair(next.first, dist[next.first]))
            }
        }
    }

    return Pair(dist.filter { it != -1 }.size, dist.maxOrNull() ?: 0)
}