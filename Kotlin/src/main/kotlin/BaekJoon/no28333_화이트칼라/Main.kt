package BaekJoon.no28333_화이트칼라

lateinit var to: Array<HashSet<Int>>
lateinit var from: Array<HashSet<Int>>

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    fun fillDist(n: Int, dist: IntArray) {
        val q = ArrayDeque<Int>()

        q.add(1)
        dist[1] = 0

        while (q.isNotEmpty()) {
            val cur = q.removeFirst()

            for (next in to[cur]) {
                if (dist[next] > dist[cur] + 1) {
                    dist[next] = dist[cur] + 1
                    q.add(next)
                }
            }
        }
    }

    fun searchPath(n: Int, dist: IntArray) {
        val q = ArrayDeque<Int>()

        q.add(n)

        while (q.isNotEmpty()) {
            val cur = q.removeFirst()

            for (prev in from[cur]) {
                if (dist[cur] == -1) continue
                else if (dist[cur] - 1 == dist[prev]) q.add(prev)
            }

            dist[cur] = -1
        }
    }

    repeat(readLine().toInt()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        var dist = IntArray(n + 1) { Int.MAX_VALUE }

        to = Array(n + 1) { HashSet() }
        from = Array(n + 1) { HashSet() }

        repeat(m) {
            val (a, b) = readLine().split(" ").map { it.toInt() }

            to[a].add(b)
            from[b].add(a)
        }

        fillDist(n, dist)
        searchPath(n, dist)

        dist.forEachIndexed { i, v -> if (v == -1) sb.append("$i ") }
        sb.append("\n")
    }

    print(sb.toString())
}
