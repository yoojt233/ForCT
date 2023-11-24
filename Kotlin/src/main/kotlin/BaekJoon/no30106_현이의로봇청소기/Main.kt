package BaekJoon.no30106_현이의로봇청소기

import java.util.Queue
import java.util.LinkedList
import kotlin.math.abs

lateinit var board: Array<IntArray>
lateinit var visited: Array<BooleanArray>
lateinit var parent: IntArray
lateinit var count: IntArray

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    board = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    visited = Array(n) { BooleanArray(m) }
    parent = IntArray(n * m) { it }
    count = IntArray(n * m) { 1 }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (visited[i][j]) continue
            visited[i][j] = true
            bfs(n, m, k, i, j)
        }
    }

    print(count.filter { i -> i > 0 }.size)
}

fun bfs(n: Int, m: Int, k: Int, r: Int, c: Int) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(r, c))

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (d in 0 until 4) {
            val nr = cur.first + dx[d]
            val nc = cur.second + dy[d]

            if (nr !in 0 until n || nc !in 0 until m || visited[nr][nc] || abs(board[cur.first][cur.second] - board[nr][nc]) > k) continue
            union(cur.first * m + cur.second, nr * m + nc)
            visited[nr][nc] = true
            q.add(Pair(nr, nc))
        }
    }
}

fun find(x: Int): Int {
    if (parent[x] != x) parent[x] = find(parent[x])
    return parent[x]
}

fun union(a: Int, b: Int) {
    val roots = Pair(find(a), find(b))
    if (count[roots.first] >= count[roots.second]) {
        count[roots.first] += count[roots.second]
        count[roots.second] = 0
        parent[roots.second] = parent[roots.first]
    } else {
        count[roots.second] += count[roots.first]
        count[roots.first] = 0
        parent[roots.first] = parent[roots.second]
    }
}
