package BaekJoon.no2228_구간나누기

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val nums = IntArray(n + 1)
    val dp = Array(m + 1) { IntArray(n + 1) { Int.MIN_VALUE } }

    for (i in 1..n) nums[i] = readLine().toInt()
    dp[0].fill(0)

    for (i in 1..m) {
        for (j in 1..n) {
            var temp = 0

            dp[i][j] = dp[i][j - 1]
            for (x in j downTo 1) {
                val prev = if (x > 1) dp[i - 1][x - 2] else if (i == 1) 0 else Int.MIN_VALUE

                temp += nums[x]
                if (prev != Int.MIN_VALUE) dp[i][j] = dp[i][j].coerceAtLeast(prev + temp)
            }
        }
    }

    println(dp[m][n])
}
