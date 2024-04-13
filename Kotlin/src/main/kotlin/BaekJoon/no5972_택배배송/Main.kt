package BaekJoon.no5972_택배배송

import java.util.PriorityQueue

data class Node(val num: Int, val cost: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return cost - other.cost
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { ArrayList<Node>() }

    repeat(m) {
        val (a, b, cost) = readLine().split(" ").map { it.toInt() }

        graph[a].add(Node(b, cost))
        graph[b].add(Node(a, cost))
    }

    fun dijkstra(op: Int, ed: Int): Int {
        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Node>()

        dist[op] = 0
        pq.add(Node(op, 0))

        while (pq.isNotEmpty()) {
            val cur = pq.poll()

            for (next in graph[cur.num]) {
                if (dist[next.num] <= cur.cost + next.cost) continue

                dist[next.num] = dist[cur.num] + next.cost
                pq.add(Node(next.num, dist[next.num]))
            }
        }

        return dist[ed]
    }

    print(dijkstra(1, n))
}