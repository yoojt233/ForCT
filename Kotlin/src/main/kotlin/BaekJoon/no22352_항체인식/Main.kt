package BaekJoon.no22352_항체인식

import java.util.*

lateinit var before: Array<IntArray>
lateinit var after: Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    before = Array(n) { IntArray(m) }
    after = Array(n) { IntArray(m) }

    repeat(n) { i ->
        before[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    repeat(n) { i ->
        after[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    var flag = true
    out@ for (i in 0 until n) {
        for (j in 0 until m) {
            if (after[i][j] != before[i][j]) {
                bfs(n, m, after[i][j], Pair(i, j))
                break@out
            }
        }
    }

    ans@ for (i in 0 until n) {
        for (j in 0 until m) {
            if (after[i][j] != before[i][j]) {
                flag = false
                break@ans
            }
        }
    }

    print(if (flag) "YES" else "NO")
}

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
fun bfs(n: Int, m: Int, num: Int, op: Pair<Int, Int>) {
    val visited = Array(n) { BooleanArray(m) }
    val q: Queue<Pair<Int, Int>> = LinkedList()

    val origin = before[op.first][op.second]
    before[op.first][op.second] = num
    visited[op.first][op.second] = true
    q.add(op)

    while (q.isNotEmpty()) {
        val cur = q.poll()
        for (d in 0 until 4) {
            val nr = cur.first + dx[d]
            val nc = cur.second + dy[d]

            if (nr !in 0 until n || nc !in 0 until m || before[nr][nc] != origin || visited[nr][nc]) continue
            before[nr][nc] = num
            visited[nr][nc] = true
            q.add(Pair(nr, nc))
        }
    }
}
