package BaekJoon.no2240_자두나무

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    val drops = IntArray(input[0]) { readLine().toInt() - 1 }
    val dp = Array(input[1] + 1) { IntArray(2) }
    var ans = 0

    for (pos in drops) {
        for (i in pos..input[1] step (2)) {
            if (i == 0) ++dp[i][i]
            else dp[i][pos] = max(dp[i][pos], dp[i - 1][(pos + 1) % 2]) + 1

            ans = max(ans, dp[i][pos])
        }
    }

    print(ans)
}
