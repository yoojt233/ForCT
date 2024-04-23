package BaekJoon.no1719_택배

import java.util.LinkedList
import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = HashMap<Int, LinkedList<Pair<Int, Int>>>()
    val ans = Array(n) { Array(n) { "-" } }

    repeat(n) {
        graph[it] = LinkedList()
    }

    repeat(m) {
        val (from, to, cost) = readLine().split(" ").map { it.toInt() }
        graph[from - 1]!!.add(Pair(to - 1, cost))
        graph[to - 1]!!.add(Pair(from - 1, cost))
    }

    fun dijkstra(op: Int) {
        val visited = BooleanArray(n)
        val dist = IntArray(n) { Int.MAX_VALUE }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        dist[op] = 0
        pq.add(Pair(op, 0))

        while (pq.isNotEmpty()) {
            val cur = pq.poll()

            if (dist[cur.first] < cur.second) continue
            visited[cur.first] = true

            for (next in graph[cur.first]!!) {
                if (visited[next.first] || cur.second + next.second >= dist[next.first]) continue

                dist[next.first] = cur.second + next.second
                ans[next.first][op] = (cur.first + 1).toString()
                pq.add(Pair(next.first, dist[next.first]))
            }
        }
    }

    repeat(n) {
        dijkstra(it)
    }

    val sb = StringBuilder()
    for (row in ans) {
        row.map { sb.append("$it ") }
        sb.append("\n")
    }
    print(sb)
}
