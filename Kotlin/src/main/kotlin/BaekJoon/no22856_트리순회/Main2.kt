package BaekJoon.no22856_트리순회

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()
    val graph = Array(n + 1) { Pair(0, 0) }

    repeat(n) {
        val (c, l, r) = readLine().split(" ").map { it.toInt() }

        graph[c] = Pair(l, r)
    }

    val path = ArrayList<Int>()

    fun dfs(cur: Int) {
        if (graph[cur].first != -1) dfs(graph[cur].first)
        path.add(cur)
        if (graph[cur].second != -1) dfs(graph[cur].second)
    }

    dfs(1)

    var back = 0
    val last = path.last()
    val q = ArrayDeque<Pair<Int, Int>>()

    q.add(Pair(1, 0))
    while (q.isNotEmpty()) {
        val temp = q.removeFirst()
        val cur = temp.first
        val level = temp.second

        if (cur == last) {
            back = level
            break
        }

        if (graph[cur].second != -1) q.add(Pair(graph[cur].second, level + 1))
        if (graph[cur].first != -1) q.add(Pair(graph[cur].first, level + 1))
    }

    print((path.size - 1) * 2 - back)
}
