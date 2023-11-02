package BaekJoon.no11048_이동하기

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val board = Array(n) { IntArray(m) }
    repeat(n) { i -> board[i] = readLine().split(" ").map { it.toInt() }.toIntArray() }

    val dp = Array(n) { IntArray(m) }
    dp[0][0] = board[0][0]
    for (i in 0 until n + m - 2) {
        for (r in 0..i) {
            val c = i - r
            if (r >= n || c >= m) continue
            if (r + 1 < n) dp[r + 1][c] = max(dp[r + 1][c], dp[r][c] + board[r + 1][c])
            if (c + 1 < m) dp[r][c + 1] = max(dp[r][c + 1], dp[r][c] + board[r][c + 1])
        }
    }

    print(dp[n - 1][m - 1])
}