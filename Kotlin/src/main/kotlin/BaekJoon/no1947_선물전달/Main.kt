package BaekJoon.no1947_선물전달

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val dp = LongArray(max(3, n + 1));
    dp[2] = 1;

    val mod = 1_000_000_000;
    for (i in 3..n) dp[i] = ((i - 1) * (dp[i - 2] + dp[i - 1])) % mod;
    print(dp[n])
}