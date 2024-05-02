package BaekJoon.`no16931_겉넓이 구하기`

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val floor = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    fun check(r: Int, c: Int): Int {
        var res = 0

        for (d in 0 until 4) {
            val nr = r + dx[d]
            val nc = c + dy[d]

            if (nr !in 0 until n || nc !in 0 until m) continue
            res += min(floor[r][c], floor[nr][nc])
        }

        return res
    }

    var ans = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            ans += (4 * floor[i][j] + 2)
            ans -= check(i, j)
        }
    }

    print(ans)
}
