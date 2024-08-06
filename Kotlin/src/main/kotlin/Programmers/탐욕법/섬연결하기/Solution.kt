package Programmers.탐욕법.섬연결하기

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main() {
    val n = 4
    val costs = arrayOf(
        intArrayOf(0, 1, 1),
        intArrayOf(0, 2, 2),
        intArrayOf(1, 2, 5),
        intArrayOf(1, 3, 1),
        intArrayOf(2, 3, 8)
    )

    print(Solution().solution(n, costs))
}

class Solution {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var res = 0
        val graph = HashMap<Int, ArrayList<Pair<Int, Int>>>()

        repeat(n) {
            graph[it] = ArrayList()
        }

        for (cost in costs) {
            graph[cost[0]]!!.add(Pair(cost[1], cost[2]))
            graph[cost[1]]!!.add(Pair(cost[0], cost[2]))
        }

        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq.add(Pair(0, 0))

        val visited = BooleanArray(n)

        while (!pq.isEmpty()) {
            val cur = pq.poll()
            if (visited[cur.first]) continue

            res += cur.second
            visited[cur.first] = true

            for (next in graph[cur.first]!!) {
                if (visited[next.first]) continue
                pq.add(next)
            }
        }

        return res
    }
}
