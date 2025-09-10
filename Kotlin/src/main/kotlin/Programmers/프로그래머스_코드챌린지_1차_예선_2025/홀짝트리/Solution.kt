package Programmers.프로그래머스_코드챌린지_1차_예선_2025.홀짝트리

class Solution {
    fun solution(nodes: IntArray, edges: Array<IntArray>): IntArray {
        val size = nodes.maxOrNull()!!

        val parent = IntArray(size + 1) { it }
        val child = IntArray(size + 1)
        val roots = HashSet<Int>()
        val type = Array(size + 1) { IntArray(2) }
        val ans = intArrayOf(0, 0)

        fun find(x: Int): Int {
            if (x != parent[x]) parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(a: Int, b: Int) {
            parent[find(b)] = find(a)
        }

        for ((a, b) in edges) {
            union(a, b)

            ++child[a]
            ++child[b]
        }

        for (node in nodes) {
            val p = find(node)

            roots.add(p)
            ++type[p][(node + child[node]) % 2]
        }

        for (r in roots) {
            for (i in 0 until 2) {
                if (type[r][i] == 1) ++ans[i]
            }
        }

        return ans
    }
}

fun main() {
    val nodes = intArrayOf(9, 15, 14, 7, 6, 1, 2, 4, 5, 11, 8, 10)
    val edges = arrayOf(
        intArrayOf(5, 14), intArrayOf(1, 4),
        intArrayOf(9, 11), intArrayOf(2, 15),
        intArrayOf(2, 5), intArrayOf(9, 7),
        intArrayOf(8, 1), intArrayOf(6, 4)
    )

    val ans = Solution().solution(nodes, edges)
    print("[${ans[0]}, ${ans[1]}]")
}
