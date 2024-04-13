package BaekJoon.no4179_불

import java.util.LinkedList
import java.util.Queue

data class Pos(val r: Int, val c: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { CharArray(m) { '.' } }

    val jihoon: Queue<Pos> = LinkedList()
    val fire: Queue<Pos> = LinkedList()
    repeat(n) { i ->
        val temp = readLine()
        repeat(m) { j ->
            board[i][j] = temp[j]
            if (temp[j] == 'J') jihoon.offer(Pos(i, j))
            else if (temp[j] == 'F') {
                fire.offer(Pos(i, j))
                board[i][j] = '#'
            }
        }
    }

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    fun bfs(): Boolean {
        val visited = Array(n) { BooleanArray(m) }
        visited[jihoon.peek().r][jihoon.peek().c] = true

        var time = 0
        while (jihoon.isNotEmpty()) {
            repeat(jihoon.size) {
                val cur = jihoon.poll()
                if (board[cur.r][cur.c] == '#') return@repeat

                for (d in 0 until 4) {
                    val nr = cur.r + dx[d]
                    val nc = cur.c + dy[d]

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                        print(time + 1)
                        return true
                    } else if (board[nr][nc] != '.' || visited[nr][nc]) continue
                    visited[nr][nc] = true
                    jihoon.offer(Pos(nr, nc))
                }
            }

            repeat(fire.size) {
                val f = fire.poll()
                for (d in 0 until 4) {
                    val nr = f.r + dx[d]
                    val nc = f.c + dy[d]

                    if (nr !in 0 until n || nc !in 0 until m || board[nr][nc] != '.') continue
                    board[nr][nc] = '#'
                    fire.offer(Pos(nr, nc))
                }
            }
            ++time
        }
        return false
    }

    if (!bfs()) print("IMPOSSIBLE")
}
