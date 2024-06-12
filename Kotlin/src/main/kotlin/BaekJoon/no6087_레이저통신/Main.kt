package BaekJoon.no6087_레이저통신

import java.util.PriorityQueue

data class Pos(val r: Int, val c: Int, val mirror: Int = 0, val prev: Int = -1) : Comparable<Pos> {
    override fun compareTo(other: Pos): Int {
        return mirror - other.mirror
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { CharArray(m) }
    val targets = ArrayList<Pair<Int, Int>>()

    var ans = Int.MAX_VALUE

    repeat(n) { i ->
        val temp = readLine().toCharArray()

        repeat(m) { j ->
            board[i][j] = temp[j]

            if (board[i][j] == 'C') targets.add(Pair(i, j))
        }
    }

    fun bfs() {
        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, -1, 0, 1)

        val visited = Array(4) { Array(n) { IntArray(m) { Int.MAX_VALUE } } }
        val q = PriorityQueue<Pos>()

        q.add(Pos(targets[0].first, targets[0].second))

        while (q.isNotEmpty()) {
            val cur = q.poll()

            if (cur.r == targets[1].first && cur.c == targets[1].second) {
                ans = ans.coerceAtMost(cur.mirror)
                continue
            }

            for (d in 0 until 4) {
                val nr = cur.r + dx[d]
                val nc = cur.c + dy[d]
                val nm = if (cur.prev == -1 || cur.prev == d) cur.mirror else cur.mirror + 1

                if (nr !in 0 until n || nc !in 0 until m || board[nr][nc] == '*' || visited[d][nr][nc] <= nm) continue
                if (cur.prev != -1 && (cur.prev + 2) % 4 == d) continue

                visited[d][nr][nc] = nm
                q.add(Pos(nr, nc, nm, d))
            }
        }
    }

    bfs()
    print(ans)
}
