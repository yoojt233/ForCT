package Programmers.그래프.가장먼노드

fun main() {
    val n = 6
    val vertex = arrayOf(
        intArrayOf(3, 6),
        intArrayOf(4, 3),
        intArrayOf(3, 2),
        intArrayOf(1, 3),
        intArrayOf(1, 2),
        intArrayOf(2, 4),
        intArrayOf(5, 2)
    )

    print(solution(n, vertex))
}

fun solution(n: Int, edge: Array<IntArray>): Int {
    val map = HashMap<Int, ArrayDeque<Int>>()
    val visited = IntArray(n + 1)
    var farther = 0

    for (i in 1..n) map[i] = ArrayDeque()

    for (e in edge) {
        map[e[0]]!!.add(e[1])
        map[e[1]]!!.add(e[0])
    }

    fun bfs(op: Int): Int {
        val q = ArrayDeque<Int>()
        q.add(op)

        while (q.isNotEmpty()) {
            val cur = q.removeFirst()

            for (next in map[cur]!!) {
                if (next == 1 || visited[next] != 0) continue

                visited[next] = visited[cur] + 1
                farther = farther.coerceAtLeast(visited[next])
                q.add(next)
            }
        }

        return visited.count { it == farther }
    }

    return bfs(1)
}
