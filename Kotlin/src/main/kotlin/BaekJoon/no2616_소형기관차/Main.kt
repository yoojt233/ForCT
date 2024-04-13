package BaekJoon.no2616_소형기관차

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val customers = readLine().split(" ").map { it.toInt() }
    val k = readLine().toInt()

    val ps = IntArray(n + 1)
    for (i in 1..n) ps[i] = ps[i - 1] + customers[i - 1]

    val dp = Array(3) { IntArray(n - k + 2) }
    for (j in 1 until n - k + 2) {
        val num = ps[j + k - 1] - ps[j - 1]

        dp[0][j] = dp[0][j - 1].coerceAtLeast(num)
        for (i in 1 until 3) {
            if (j - (k * i) < 0) continue
            dp[i][j] = dp[i][j - 1].coerceAtLeast(dp[i - 1][j - k] + num)
        }
    }

    print(dp[2][n - k + 1])
}
