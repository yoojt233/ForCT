package BaekJoon.no30106_현이의로봇청소기

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(n) { BooleanArray(m) }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    fun bfs(r: Int, c: Int) {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(Pair(r, c))

        while (q.isNotEmpty()) {
            val cur = q.poll()

            for (d in 0 until 4) {
                val nr = cur.first + dx[d]
                val nc = cur.second + dy[d]

                if (nr !in 0 until n || nc !in 0 until m || visited[nr][nc] || abs(board[cur.first][cur.second] - board[nr][nc]) > k) continue
                visited[nr][nc] = true
                q.add(Pair(nr, nc))
            }
        }
    }

    var res = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (visited[i][j]) continue
            ++res
            visited[i][j] = true
            bfs(i, j)
        }
    }

    print(res)
}
