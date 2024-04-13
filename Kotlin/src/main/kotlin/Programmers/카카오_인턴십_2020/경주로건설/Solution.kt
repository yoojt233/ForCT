package Programmers.카카오_인턴십_2020.경주로건설

import kotlin.math.min

fun main() {
    val board = arrayOf(intArrayOf(0, 0, 1, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 1, 0, 1), intArrayOf(1, 0, 0, 0))
    print(solution(board))
}

fun solution(board: Array<IntArray>): Int {
    val n = board.size
    return bfs(n, board)
}

fun bfs(n: Int, board: Array<IntArray>): Int {
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    var res = Integer.MAX_VALUE

    val visited = Array(n) { Array(n) { BooleanArray(4) } }
    val costs = Array(n) { IntArray(n) }

    val q: ArrayDeque<Path> = ArrayDeque()
    q.add(Path(0, 0, 0, -1))

    while (q.isNotEmpty()) {
        val cur = q.removeLast()

        for (d in 0 until 4) {
            val nr = cur.r + dx[d]
            val nc = cur.c + dy[d]

            if (nr !in 0 until n || nc !in 0 until n || board[nr][nc] == 1) continue

            var ncost = cur.cost
            ncost += if (cur.dir == -1 || cur.dir == d) 100 else 600

            if (nr == n - 1 && nc == n - 1) res = min(res, ncost)
            else if (!visited[nr][nc][d] || costs[nr][nc] >= ncost) {
                q.add(Path(nr, nc, ncost, d))
                visited[nr][nc][d] = true
                costs[nr][nc] = ncost
            }
        }
    }

    return res
}

data class Path(val r: Int, val c: Int, val cost: Int, val dir: Int)