package BaekJoon.no4883_삼각그래프

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    var n = readLine().toInt()
    var k = 1

    while (n != 0) {
        val dp = Array(n) { readLine().split(" ").map { it.toLong() }.toLongArray() }

        dp[0][0] = 1001
        dp[0][2] += dp[0][1]

        for (i in 1 until n) {
            dp[i][0] += dp[i - 1][0].coerceAtMost(dp[i - 1][1])
            dp[i][1] += dp[i - 1][0].coerceAtMost(dp[i - 1][1]).coerceAtMost(dp[i - 1][2].coerceAtMost(dp[i][0]))
            dp[i][2] += dp[i - 1][1].coerceAtMost(dp[i - 1][2].coerceAtMost(dp[i][1]))
        }

        sb.append("${k++}. ${dp[n - 1][1]}\n")
        n = readLine().toInt()
    }

    println(sb.toString())
}
