package Programmers.KAKAO_BLIND_RECRUITMENT_2022.양과늑대

import kotlin.math.max

fun main() {
    val info = intArrayOf(0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0)
    val edges = arrayOf(
        intArrayOf(0, 1), intArrayOf(0, 2),
        intArrayOf(1, 3), intArrayOf(1, 4),
        intArrayOf(2, 5), intArrayOf(2, 6),
        intArrayOf(3, 7), intArrayOf(4, 8),
        intArrayOf(6, 9), intArrayOf(9, 10),
    )

    print(Solution().solution(info, edges))
}

class Solution {
    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        val nodes = Array(info.size) { ArrayList<Int>() }

        var ans = 0

        for (e in edges) {
            val from = e[0]
            val to = e[1]

            nodes[from].add(to)
        }

        fun dfs(cur: Int, lamb: Int, wolf: Int, q: ArrayDeque<Int>) {
            val nl = lamb + (info[cur] xor 1)
            val nw = wolf + info[cur]

            if (nl <= nw) return

            val nq = ArrayDeque(q)
            for (child in nodes[cur]) nq.add(child)

            ans = max(ans, nl)

            repeat(nq.size) {
                val next = nq.removeFirst()

                dfs(next, nl, nw, nq)
                nq.add(next)
            }
        }

        dfs(0, 0, 0, ArrayDeque())

        return ans
    }
}
