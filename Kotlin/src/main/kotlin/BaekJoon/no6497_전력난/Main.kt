package BaekJoon.no6497_전력난

import java.util.PriorityQueue

data class Edge(val to: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return cost.compareTo(other.cost)
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    var (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = HashMap<Int, ArrayList<Edge>>()

    while (n + m != 0) {
        var total = 0

        repeat(n) {
            graph[it] = ArrayList()
        }

        repeat(m) {
            val (a, b, dist) = readLine().split(" ").map { it.toInt() }

            graph[a]!!.add(Edge(b, dist))
            graph[b]!!.add(Edge(a, dist))

            total += dist
        }

        val pq = PriorityQueue<Edge>()
        pq.add(Edge(0, 0))

        val visited = BooleanArray(n)

        var temp = 0
        while (pq.isNotEmpty()) {
            val cur = pq.poll()

            if (visited[cur.to]) continue

            visited[cur.to] = true
            temp += cur.cost
            for (next in graph[cur.to]!!) pq.add(next)
        }

        sb.append("${total - temp}\n")

        var (nn, nm) = readLine().split(" ").map { it.toInt() }
        n = nn
        m = nm
    }

    print(sb.toString())
}
