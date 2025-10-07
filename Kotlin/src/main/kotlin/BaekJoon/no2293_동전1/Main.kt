package BaekJoon.no2293_동전1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val coins = IntArray(n) { readLine().toInt() }
    val dp = IntArray(k + 1)

    dp[0] = 1
    for (coin in coins) {
        for (i in 1..k) dp[i] += if (i - coin >= 0) dp[i - coin] else 0
    }

    println(dp[k])
}
