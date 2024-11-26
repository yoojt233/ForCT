package BaekJoon.no3372_보드점프

import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val board = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val d = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
    var dp = Array(n) { Array(n) { BigInteger("-1") } }

    fun dfs(r: Int, c: Int): BigInteger {
        if (r !in 0 until n || c !in 0 until n) return BigInteger.ZERO
        if (r == n - 1 && c == n - 1) return BigInteger.ONE
        if (dp[r][c] != BigInteger("-1")) return dp[r][c]

        dp[r][c] = BigInteger.ZERO

        val step = board[r][c]
        for (i in d.indices) dp[r][c] += dfs(r + d[i][0] * step, c + d[i][1] * step)

        return dp[r][c]
    }

    print(dfs(0, 0))
}
