package BaekJoon.no11967_불켜기

import java.util.LinkedList

data class Pos(val r: Int, val c: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val switches = Array(n) { Array(n) { ArrayList<Pos>() } }
    var ans = 1

    repeat(m) {
        val (br, bc, tr, tc) = readLine().split(" ").map { it.toInt() - 1 }
        switches[br][bc].add(Pos(tr, tc))
    }

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    val isLight = Array(n) { BooleanArray(n) }
    isLight[0][0] = true

    fun bfs() {
        val visited = Array(n) { BooleanArray(n) }
        visited[0][0] = true

        val q = LinkedList<Pos>()
        q.add(Pos(0, 0))

        var flag = false
        while (q.isNotEmpty()) {
            val cur = q.poll()

            for (next in switches[cur.r][cur.c]) {
                if (isLight[next.r][next.c]) continue

                ++ans
                isLight[next.r][next.c] = true
                flag = true
            }

            for (d in 0 until 4) {
                val nr = cur.r + dx[d]
                val nc = cur.c + dy[d]

                if (nr !in 0 until n || nc !in 0 until n || !isLight[nr][nc] || visited[nr][nc]) continue

                q.add(Pos(nr, nc))
                visited[nr][nc] = true
            }
        }

        if (flag) bfs()
    }

    bfs()
    print(ans)
}
