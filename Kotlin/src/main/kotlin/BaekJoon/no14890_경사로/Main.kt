package BaekJoon.no14890_경사로

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val (n, l) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    var ans = 0

    for (i in 0 until n) ans += (check(n, board, l, i, true) + check(n, board, l, i, false))

    print(ans)
}

fun check(n: Int, board: Array<IntArray>, l: Int, idx: Int, flag: Boolean): Int {
    var prev = if (flag) board[idx][0] else board[0][idx]
    var cnt = 1

    for (i in 1 until n) {
        val cur = if (flag) board[idx][i] else board[i][idx]

        if (abs(prev - cur) > 1) return 0

        if (prev == cur) {
            cnt++
            continue
        } else if (prev < cur) {
            if (cnt >= l) {
                prev = cur
                cnt = 1
            } else return 0
        } else {
            if (cnt < 0) return 0

            prev = cur
            cnt = -l + 1
        }
    }

    if (cnt < 0) return 0

    return 1
}
