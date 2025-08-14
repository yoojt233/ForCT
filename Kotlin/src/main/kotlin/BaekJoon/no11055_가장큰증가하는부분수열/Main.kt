package BaekJoon.no11055_가장큰증가하는부분수열

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val input = readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n + 1)

    var ans = 0

    for (i in input.indices) {
        dp[i + 1] = input[i]

        for (j in 0 until i) {
            if (input[j] < input[i]) dp[i + 1] = max(dp[i + 1], dp[j + 1] + input[i])
        }

        ans = max(ans, dp[i + 1])
    }

    println(ans)
}
