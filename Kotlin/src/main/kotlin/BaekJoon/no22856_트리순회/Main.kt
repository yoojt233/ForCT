package BaekJoon.no22856_트리순회

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()
    val graph = Array(n + 1) { Pair(0, 0) }

    repeat(n) {
        val (c, l, r) = readLine().split(" ").map { it.toInt() }

        graph[c] = Pair(l, r)
    }

    val path = ArrayList<Int>()
    var back = 0

    fun dfs(cur: Int) {
        if (graph[cur].first != -1) dfs(graph[cur].first)
        path.add(cur)
        if (graph[cur].second != -1) dfs(graph[cur].second)
    }

    fun dfs(cur: Int, level: Int, last: Int) {
        if (cur == last) {
            back = level
            return
        }

        if (graph[cur].second != -1) dfs(graph[cur].second, level + 1, last)
        if (graph[cur].first != -1) dfs(graph[cur].first, level + 1, last)
    }

    dfs(1)
    dfs(1, 0, path.last())

    print((path.size - 1) * 2 - back)
}
