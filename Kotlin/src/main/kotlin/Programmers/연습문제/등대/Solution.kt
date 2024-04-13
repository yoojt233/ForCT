package Programmers.연습문제.등대

fun main() = with(System.`in`.bufferedReader()) {
    val n = 8
    val lighthouse = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, 3),
        intArrayOf(1, 4),
        intArrayOf(1, 5),
        intArrayOf(5, 6),
        intArrayOf(5, 7),
        intArrayOf(5, 8),
    )

    print(solution(n, lighthouse))
}

var res = 0

fun solution(n: Int, lighthouse: Array<IntArray>): Int {
    val graph = Array(n + 1) { ArrayList<Int>() }
    for (lights in lighthouse) {
        graph[lights[0]].add(lights[1])
        graph[lights[1]].add(lights[0])
    }
    dfs(graph, 1, 0)
    return res
}

fun dfs(graph: Array<ArrayList<Int>>, cur: Int, prev: Int): Int {
    if (graph[cur].size == 1 && graph[cur][0] == prev) return 1

    var temp = 0
    for (next in graph[cur]) {
        if (next == prev) continue
        temp += dfs(graph, next, cur)
    }

    if (temp == 0) return 1
    ++res
    return 0
}