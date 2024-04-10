package BaekJoon.no1535_안녕

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val costs = readLine().split(" ").map { it.toInt() }
    val pleasures = readLine().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { IntArray(100) }

    for (i in 1..n) {
        for (hp in 99 downTo 1) {
            val cost = costs[i - 1]
            val pleasure = pleasures[i - 1]

            dp[i][hp] =
                if (cost <= hp && dp[i - 1][hp - cost] + pleasure > dp[i - 1][hp]) dp[i - 1][hp - cost] + pleasure
                else dp[i - 1][hp]
        }
    }

    print(dp[n][99])
}
