package BaekJoon.no7570_줄세우기

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val dp = IntArray(n + 1);

    var longest = 0;
    for (cur in readLine().split(" ").map { it.toInt() }) {
        dp[cur] = dp[cur - 1] + 1;
        longest = max(longest, dp[cur]);
    }
    print(n - longest);
}