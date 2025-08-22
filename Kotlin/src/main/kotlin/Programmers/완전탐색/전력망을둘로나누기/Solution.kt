package Programmers.완전탐색.전력망을둘로나누기

import kotlin.math.min
import kotlin.math.abs

fun bfs(graph: Map<Int, ArrayList<Int>>, op: Int, a: Int, b: Int): Int {
    val dq = ArrayDeque<Int>()
    val visited = hashSetOf(op)

    var res = 1

    dq.add(op)
    while (dq.isNotEmpty()) {
        val cur = dq.removeFirst()

        for (i in graph[cur]!!.indices) {
            val next = graph[cur]!![i]

            if (visited.contains(next) || (cur == a && next == b) || (cur == b && next == a)) continue

            visited.add(next)
            dq.add(next)
            ++res
        }
    }

    return res
}

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        val graph = buildMap<Int, ArrayList<Int>> {
            for ((a, b) in wires) {
                computeIfAbsent(a - 1) { arrayListOf() }
                computeIfAbsent(b - 1) { arrayListOf() }

                this[a - 1]!!.add(b - 1)
                this[b - 1]!!.add(a - 1)
            }
        }

        var res = n

        for ((a, b) in wires) {
            val net1 = bfs(graph, 0, a - 1, b - 1)

            res = min(res, abs(2 * net1 - n))
        }

        return res
    }
}

fun main() {
    val n = 8
    val wires = arrayOf(
        intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(1, 4),
        intArrayOf(4, 5), intArrayOf(5, 6), intArrayOf(6, 7),
        intArrayOf(6, 8)
    )

    println(Solution().solution(n, wires))
}