package BaekJoon.no14950_정복자

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, t) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { HashMap<Int, Int>() }
    var chance = 0
    var ans = 0

    repeat(m) {
        val (from, to, cost) = readLine().split(" ").map { it.toInt() }

        graph[from - 1][to - 1] = cost
        graph[to - 1][from - 1] = cost
    }

    val visited = BooleanArray(n)
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    pq.add(Pair(0, 0))

    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        if (visited[cur.first]) continue

        visited[cur.first] = true
        if (cur.first != 0) ans += cur.second + t * chance++

        for (next in graph[cur.first].keys) {
            if (visited[next]) continue

            pq.add(Pair(next, graph[cur.first][next]!!))
        }
    }

    print(ans)
}
