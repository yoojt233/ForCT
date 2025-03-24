package Programmers.KAKAO_BLIND_RECRUITMENT_2021.합승택시요금

import java.util.PriorityQueue
import kotlin.math.min

fun main() {
    val n = 7
    val s = 3
    val a = 4
    val b = 1
    var fares = arrayOf(
        intArrayOf(5, 7, 9),
        intArrayOf(4, 6, 4),
        intArrayOf(3, 6, 1),
        intArrayOf(3, 2, 3),
        intArrayOf(2, 1, 6)
    )

    print(Solution().solution(n, s, a, b, fares))
}

class Solution {
    data class Node(val num: Int, val cost: Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return cost - other.cost
        }
    }

    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        val graph = Array(n + 1) { ArrayList<Node>() }

        var res = Int.MAX_VALUE

        for ((from, to, cost) in fares) {
            graph[from].add(Node(to, cost))
            graph[to].add(Node(from, cost))
        }

        fun dijk(op: Int): IntArray {
            val dist = IntArray(n + 1) { -1 }
            val visited = BooleanArray(n + 1)
            val pq = PriorityQueue<Node>()

            dist[op] = 0
            pq.add(Node(op, 0))

            while (pq.isNotEmpty()) {
                val cur = pq.poll()

                if (visited[cur.num]) continue

                visited[cur.num] = true
                for ((next, c) in graph[cur.num]) {
                    if (dist[next] < 0 || dist[next] > cur.cost + c) {
                        dist[next] = cur.cost + c
                        pq.add(Node(next, dist[next]))
                    }
                }
            }

            return dist
        }

        val sDijk = dijk(s)
        val aDijk = dijk(a)
        val bDijk = dijk(b)

        for (i in 1..n) {
            if (sDijk[i] < 0 || aDijk[i] < 0 || bDijk[i] < 0) continue

            res = min(res, sDijk[i] + aDijk[i] + bDijk[i])
        }

        return res
    }
}
